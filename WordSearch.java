class Solution {
    public boolean exist(char[][] board, String word) {
       if (word == "")
           return false;
        
        boolean res = false;
        int[][] check = new int[board.length][board[0].length];
        for (int i=0; i<board.length;i++)
        {
            for (int j=0; j<board[0].length; j++)
            {
                if (board[i][j] == word.charAt(0))
                {
                    
                     res = existHelper(board, word, 0, i,j,check);
                }
                 
                
                if (res)
                    return true;
            }
        }
        return res;
        
    }
    
    private boolean existHelper(char[][] board, String word, int index, int i, int j, int[][] check)
    {
        
        if (i<0 || j<0 || i>= board.length || j>=board[0].length || check[i][j] == 1 || word.charAt(index) != board[i][j])
         return false;
        
        if (index == word.length() - 1)
         return true; 
        
            check[i][j] = 1;
            
            boolean res =  (existHelper(board, word, index+1, i+1,j,check)) ||
                            (existHelper(board, word, index+1, i-1,j,check)) ||
                            (existHelper(board, word, index+1, i,j+1,check)) ||
                            (existHelper(board, word, index+1, i,j-1,check)) ;
            
            if (!res)
               check[i][j] = 0; 
                    
        return res;
    }
    
}