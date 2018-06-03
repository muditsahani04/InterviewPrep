class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum+= num;
        
        if (sum%2 != 0)
            return false;
        
        sum = sum/2;
        int r = nums.length;
        boolean[][] dp = new boolean[r][sum+1];
         for(int i = 0; i < nums.length; i++) dp[i][0] = true;
        for(int i=0; i<sum+1; i++)
        {
            if (i == nums[0])
                dp[0][i] = true;
        }
        
        for (int i=1; i<r; i++)
        {
            for (int j=1; j<sum+1; j++)
            {
                if (j< nums[i])
                    dp[i][j] = dp[i-1][j];
                else
                {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }
        
        
        return dp[r-1][sum];
        
    }
}