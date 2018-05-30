class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<String>();
        char[] str = new char[n*2];
        addParenthesis(res, n, n, str, 0);
        return res;
    }
    
    private void addParenthesis(List<String> res, int leftParen, int rightParen, char[] str, int level)
    {
       if (leftParen < 0 || leftParen > rightParen)
           return;
        if (leftParen == 0 && rightParen == 0)
        {
            res.add(String.valueOf(str));
        }
        
        if (leftParen > 0)
        {
            str[level] = '(';
            addParenthesis(res, leftParen-1, rightParen, str, level+1);
        }
        if (rightParen > 0)
        {
            str[level] = ')';
            addParenthesis(res, leftParen, rightParen-1, str, level+1);
        }
        
        return;
    }
}