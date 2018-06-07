class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        int max = 0;
    
        if (k==0)
            return 0;
        
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character,Integer>();
        
        while (end < s.length())
        {
           if (map.containsKey(s.charAt(end)) || map.size()<k)
           {
               map.remove(s.charAt(end));
               map.put(s.charAt(end), end);
               max = Math.max(max, end - start+1);
               end++;
           }
            else
            {
                 Character key = map.keySet().iterator().next();
                 start = map.get(key);
                map.remove(key);
                start++;
            }
            
        }
        
        return max;
    }
}