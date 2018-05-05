class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        
        if(digits.length() == 0)
            return res;
        
        String[] checker = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] input = new String[digits.length()];
        for (int i=0; i<digits.length(); i++)
            input[i] = checker[Integer.parseInt(String.valueOf((digits.charAt(i))))];
        
        
        char[] str =new char[digits.length()];
        recurse(0,input,res,str);
        
        return res;
    }
    
    private void recurse(int level,String[] input, List<String> res, char[] str)
    {
        if (level == input.length)
        {
            res.add(String.valueOf(str));
            return ;
        }
        
        for (int i=0; i<input[level].length(); i++)
        {
            str[level] = input[level].charAt(i);
            recurse(level+1,input,res,str);
        }

    }
}