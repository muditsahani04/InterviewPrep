class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int[] maxOnLeft = new int[n];
        int[] maxOnRight = new int[n];
        
        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++)
        {
                maxOnLeft[i] = Math.max(height[i],max);
                max = Math.max(height[i],max);
        }
        max = Integer.MIN_VALUE;
        for (int i=n-1; i>=0; i--)
        {
                maxOnRight[i] = Math.max(height[i],max);
                max = Math.max(height[i],max);
        }
        
        int res = 0;
        
        for (int i=0; i<n; i++)
        {
            res+= Math.min(maxOnLeft[i],maxOnRight[i]) - height[i];
        }
        
        return res;
    }
}