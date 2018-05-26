class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if (wordList.isEmpty() || !wordList.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        Set<String> dict = new HashSet<String>(wordList);
        visited.add(beginWord);
        q.add(beginWord);
        q.add(null);
        int level = 1;
        while(!q.isEmpty())
        {
            String s = q.poll();
            if (s!= null)
            {
               
                for (int i=0; i< s.length(); i++)
                {
                     char[] c = s.toCharArray();
                    for (char ch='a';ch<='z'; ch++)
                    {
                        c[i] = ch;
                        
                        String word = new String(c);
                        if (dict.contains(word) && !visited.contains(word))
                        {
                            q.add(word);
                            visited.add(word);
                        }
                            
                        if (word.equals(endWord))
                            return level+1;
                    }
                }
            }
            else
            {
                level++;
                if (!q.isEmpty())
                    q.add(null);
            }
        }
          
        return 0;
    }
}