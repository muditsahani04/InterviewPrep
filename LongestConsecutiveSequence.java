class Solution {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0)
            return 0;
        
        int maxCount = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (int n: nums)
            set.add(n);
        
        for (int n : nums)
        {
            int count = 1;
            int left = n-1;
            int right = n+1;
            
            while (set.contains(left))
            {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right))
            {
                count++;
                set.remove(right);
                right++;
            }
            
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
        
    }
}