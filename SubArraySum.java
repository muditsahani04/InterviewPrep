class Solution {
    public int subarraySum(int[] nums, int k) {
    
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int sum =0;
        int count = 0;
        for (int n :nums)
        {
            sum+= n;
            if (map.get(sum-k)!= null)
                count += map.get(sum-k);
            
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        
        return count;
    }
}