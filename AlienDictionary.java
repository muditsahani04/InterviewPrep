class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 1)
            return words[0];
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		Set<Character> unused = new HashSet<Character>();
        
        for (String w : words)
        {
            for (char c : w.toCharArray())
                unused.add(c);
        }
		 map = buildEdgeList(words,unused);
    
        if (isCyclic(map))
            return "";
        StringBuilder res = new StringBuilder();
        for (Character c : unused)
		 res.append(c);
        for (char ch : topologicalSort(map))
            res.append(ch);
		return res.toString();
    }
    
    private HashMap<Character, Set<Character>> buildEdgeList(String[] strings,Set<Character> unused) {
		HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
		for (int i= strings.length-1; i>0; i--)
		{
			String s1 = strings[i];
			String s2 = strings[i-1];
			int j=0;
			while (j < Math.min(s1.length(), s2.length()) && s1.charAt(j)== s2.charAt(j))
			{
				j++;
			}
			if (j<s2.length())
			{
				if (!map.containsKey(s1.charAt(j)))
					map.put(s1.charAt(j), new HashSet<Character>());
				map.get(s1.charAt(j)).add(s2.charAt(j));
                unused.remove(s1.charAt(j));
                unused.remove(s2.charAt(j));
				j++;
			}
			
			int k = j;
			while (j< s1.length())
			{
				j++;
			}
			while ( k< s2.length())
			{
				k++;
			}	
		}
		
		return map;
	}
	
	private List<Character> topologicalSort(HashMap<Character, Set<Character>> edgeList)
	{
		
		Set<Character> visited = new HashSet<Character>();
		List<Character> res = new ArrayList<Character>();
		for (char ch : edgeList.keySet())
		{
			if (!visited.contains(ch))
			{
				sortHelper(edgeList, visited,ch, res);
			}
		}
			
		return res;
	}
	
	private void sortHelper(HashMap<Character, Set<Character>> edgeList, Set<Character> visited,char ch, List<Character> res)
	{
		if (visited.contains(ch))
			return;
		visited.add(ch);
		
        if (edgeList.containsKey(ch))
		{
            
			for (char key : edgeList.get(ch))
			{
				sortHelper(edgeList, visited, key, res);
			}
		}
		res.add(ch);
	}
	
	private boolean isCyclic(HashMap<Character, Set<Character>> edgeList)
	{
		boolean res =false;
		for (char ch : edgeList.keySet())
		{
		  Set<Character> visited = new HashSet<Character>();
		  res = isCyclicHelper(edgeList, visited, ch);
		  if (res)
			  return true;
		}
		
		return false;
	}
	
	private boolean isCyclicHelper(HashMap<Character, Set<Character>> edgeList, Set<Character> visited, char ch)
	{
		if (visited.contains(ch))
			return true;
		
		
		if (edgeList.containsKey(ch))
		{
            visited.add(ch);
			for (char key : edgeList.get(ch))
			{
				if (isCyclicHelper(edgeList, visited, key))
					return true;
			}
		}
		
		return false;
	}
}