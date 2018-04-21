
public class rotateMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[][] m = {{1,2,3},{4,5,6},{7,8,9}};
	System.out.println("Original Matrix:");
	printMatrix(m);
	rotate(m);
	System.out.println("Rotated Matrix:");
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
	public static void rotate(int Matrix[][])
	{
		for (int layer=0; layer < Matrix.length; layer++)
		{
			int first = layer;
			int last = Matrix.length - layer - 1;
			for (int j=layer; j < last; j++)
			 {
				int offset = j-layer;
				int temp = Matrix[first][j];
				Matrix[first][j] = Matrix[last-offset][first];
				Matrix[last-offset][first] = Matrix[last][last-offset];
				Matrix[last][last-offset] = Matrix[j][last];
				Matrix[j][last] = temp;
			 }
		}
	}
}
