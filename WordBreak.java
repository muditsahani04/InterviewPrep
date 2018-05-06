class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[][] matrix = new boolean[s.length()][s.length()];
        for (int l=0; l<s.length(); l++)
        {
            for (int i=0,j=l; j<s.length(); i++,j++)
            {
                if (wordDict.contains(s.substring(i,j+1)))
                    matrix[i][j] = true;
                else
                {
                    for (int k=i; k<j; k++)
                    {
                        if (matrix[i][k] && matrix[k+1][j])
                        {
                            matrix[i][j] = true;
                            
                        }
                    }
                }
            }
        }
        
        
        return matrix[0][s.length()-1];
    }
}