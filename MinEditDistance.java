class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] res = new int[n+1][m+1];
        for (int i=1; i<n+1; i++)
        {
            res[i][0] = i;
        }
        for (int i=1; i<m+1; i++)
        {
            res[0][i] = i;
        }
        
        for (int i=1; i<n+1; i++)
        {
            for (int j=1; j<m+1; j++)
            {
                if (word2.charAt(i-1)!= word1.charAt(j-1))
                    res[i][j] = Math.min(res[i][j-1], Math.min(res[i-1][j-1],res[i-1][j])) +1;
                else
                    res[i][j] = res[i-1][j-1];
            }
        }
        
        
        return res[n][m];
        
    }
}