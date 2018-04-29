class Solution {
   public int[] findOrder(int numCourses, int[][] prerequisites) {
        
	       int[] result = new int[numCourses];
	        int[] test = new int[numCourses];
	         for (int i=0; i< numCourses; i++)
	        {
	        	
	            	result[i] = i;
	             test[i] = -1;
	        }
	       if (prerequisites.length == 0)
	       {
	         
	           return result;
	       }
	           
	        HashMap<Integer,ArrayList<Integer>> edgeList = new HashMap<Integer,ArrayList<Integer>>();
	        // Prepare the edge list
	        for (int i=0; i<prerequisites.length; i++)
	        {
	            int vertex = prerequisites[i][1];
                if (edgeList.get(new Integer(prerequisites[i][0]))!= null && edgeList.get(new Integer(prerequisites[i][0])).contains(new Integer(vertex)))
	            	return new int[0];
	            if (edgeList.containsKey(new Integer(vertex)))
	            {
	                
	                edgeList.get(new Integer(vertex)).add(prerequisites[i][0]);
	            }
	                
	            else
	            {
	            	
	                ArrayList<Integer> list = new ArrayList<Integer>();
	                list.add(prerequisites[i][0]);
	                edgeList.put(new Integer(vertex), list);
	            }
	            test[prerequisites[i][0]] = 0;
	            test[prerequisites[i][1]] = 0;
	        }
	       
	       
	       if (isCyclic( edgeList))
	           return new int[0];
	           
	        Deque<Integer> stack = new ArrayDeque<Integer>();
	        HashSet<Integer> visited = new HashSet<Integer>();
	        for (Integer v : edgeList.keySet())
	        {
	            topologicalSort(visited,stack,0,v,edgeList,numCourses);
	        }
	        
	       int i =0, k=0;
	       for (i=0; i<result.length; i++)
	       {
	           if (test[i] == -1)
	           {
	               result[k] =i;
	               k++;
	           }
	       }
	        while(!stack.isEmpty())
	        {
	            
	            	result[k++] = stack.poll();
	        }
	        	
	        return result;
	    }
	    
	    private void topologicalSort (HashSet<Integer> visited, Deque<Integer>  stack, int index, int vertex, HashMap<Integer,ArrayList<Integer>> edgeList, int n)
	    {
	        if (visited.contains(new Integer(vertex)))
	            return ;
	        visited.add(new Integer(vertex));
	        if (edgeList.get(vertex) != null)
	        {
	            for (Integer v: edgeList.get(new Integer(vertex)))
	            {
	                topologicalSort(visited,stack,index,v,edgeList,n);
	            }
	        }
	        stack.push(new Integer(vertex));
	    }
	    
	    private boolean isCyclic(HashMap<Integer,ArrayList<Integer>> edgeList)
	    {	
	        boolean result;
	        HashSet<Integer> safe = new HashSet<Integer>();
	    	for (Integer key : edgeList.keySet())
	    	{
	    		HashSet<Integer> visited = new HashSet<Integer>();
	            visited.add(key);
	    		if (isCyclicHelper(edgeList, key, visited,safe))
	                return true;
	    	}
	    	return false;
	    }
	    
	    private boolean isCyclicHelper(HashMap<Integer,ArrayList<Integer>> edgeList, Integer k, HashSet<Integer> visited, HashSet<Integer> safe)
	    {
	        
	        if (edgeList.get(k)== null || edgeList.get(k).isEmpty() || safe.contains(k))
	        	 return false;
	           
	        boolean result = false;
	        visited.add(k);
	        for (Integer keys : edgeList.get(k))
	        {
	            if (result != true && !safe.contains(keys))
	            {
	                if (visited.contains(keys))
	                    return true; 
	               result = isCyclicHelper (edgeList, keys, visited,safe);
                    safe.add(keys);
	            }
	            
            }
	        return result;
	    }
        
}