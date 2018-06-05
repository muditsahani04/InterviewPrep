class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix.length == 0)
            return 0;
        int[] dp = new int[matrix[0].length];
        
        int maxRect =0;
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                if (matrix[i][j] == '0')
                    dp[j] = 0;
                else
                    dp[j]+=1;
            }
            
           maxRect = Math.max(maxRect, maxRectangleHistogram(dp)); 
            
        }
        
        return maxRect;
    }
    
    private int maxRectangleHistogram(int[] nums)
    {
       Deque<Integer> stack = new ArrayDeque<Integer>();
       int max = 0;
        int i=0;
       while(i<nums.length)
       {
           if (stack.isEmpty() || nums[i] >= nums[stack.peek()])
           {
               stack.push(i);
               i++;
           }
           else
           {
               int currMax = stack.pop();
               max = Math.max(max, nums[currMax] * (stack.isEmpty()? i : i-1-stack.peek()));
           }
       }
        while (!stack.isEmpty())
        {
            int currMax = stack.pop();
            max = Math.max(max, nums[currMax] * (stack.isEmpty()? i : i-1-stack.peek()));
        }
        
        return max;
        
    }
}