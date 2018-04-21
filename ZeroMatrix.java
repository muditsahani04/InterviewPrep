
public class ZeroMatrix {

	public static void main(String[] args) {
	// TODO Auto-generated method stub
	int[][] m = {{1,0,3},{4,5,6},{7,8,9}};
	System.out.println("Original Matrix:");
	printMatrix(m);
	zeroMatrix(m);
	System.out.println("Zero Matrix:");
	printMatrix(m);
	}
	
	public static void printMatrix(int[][] Matrix)
	{
		for (int i=0 ; i<Matrix.length ;i++)
		{
			for (int j=0; j<Matrix[0].length; j++)
			{
				System.out.print(Matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void zeroMatrix(int[][] m)
	{
	  boolean isFirstRowZero = false;
	  boolean isFirstColumnZero = false;
	  
	  for (int i=0; i < m[0].length; i++)
	  {
		if (m[0][i] == 0)
		{
			isFirstRowZero = true;
			break;
		}	
	  }
	  for (int i=0; i<m.length; i++)
	  {
		if (m[i][0] == 0)
		{
			isFirstColumnZero = true;
			break;
		}	
	  }

	  for (int i=1; i<m.length; i++)
	  {
		for (int j=1; j<m[0].length; j++)
		{
			if (m[i][j] == 0)
			{
			  m[0][j] = 0;
			  m[i][0] = 0;
			}
		}
	  }
	  
	  //nullify rows
	  for (int row=1 ; row<m.length; row++)
	  {
	   if (m[row][0] == 0)
			nullifyRow(m,row);
	  }
	  
	  
	  //nullify columns
	  for (int col=1 ; col<m[0].length; col++)
	  {
	   if (m[0][col] == 0)
			nullifyColumn(m,col);
	  }
	  
	  //nullify first row
	  if (isFirstRowZero)
		nullifyRow(m,0);
		
	  //nullify first column
	  if (isFirstColumnZero)
	    nullifyColumn(m,0);
	}

	private static void nullifyRow(int[][] m, int row)
	{
		for (int i=0; i<m[0].length; i++)
			m[row][i] = 0;
	}

	private static void nullifyColumn(int[][] m, int col)
	{
		for (int i=0; i<m.length; i++)
			m[i][col] = 0;
	}

}
