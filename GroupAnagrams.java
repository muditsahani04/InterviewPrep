import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        if (strs.length == 0)
            return res;
        HashMap<String,ArrayList<String>> resMap = new HashMap<String,ArrayList<String>>();
        for (int i=0; i<strs.length; i++)
        {
            char[] sorted = strs[i].toCharArray();
            Arrays.sort(sorted);
            if (!resMap.containsKey(String.valueOf(sorted)))
                resMap.put(String.valueOf(sorted), new ArrayList<String>());
            
            resMap.get(String.valueOf(sorted)).add(strs[i]);
             
        }
        
        for(List<String> key : resMap.values())
         res.add(key);
        return res;
        
    }

}
