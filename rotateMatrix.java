
class Solution {
    public void rotate(int[][] matrix) {
        
        int r1=0, r2 = matrix.length-1, c1=0, c2 = matrix[0].length-1;
        
        while (r1<r2 && c1<c2)
        {
            for (int r=r1,c=c2; r<r2 && c>c1; r++,c--)
            {
                int temp = matrix[r1][r];
                matrix[r1][r] = matrix[c][r1];
                matrix[c][r1] = matrix[r2][c];
                matrix[r2][c] = matrix[r][c2];
                matrix[r][c2] = temp;
            }
            r1++;
            r2--;
            c1++;
            c2--;
            
        } 
    }
}
