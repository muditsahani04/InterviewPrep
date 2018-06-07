class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int prod =1;
        int[] out = new int[nums.length];
        for (int i=0; i< nums.length; i++)
        {
            
            if (i ==0)
                out[i]=1;
            else
            {
                
                prod = prod * nums[i-1];
                out[i] = prod;
            }
                
        }
        
        prod = 1;
        
        for (int i=nums.length-2; i>=0; i--)
        {
            prod *= nums[i+1];
            out[i] = out[i]*prod;
        }
        
        return out;
    }
}