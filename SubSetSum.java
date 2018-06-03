
public class SubSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = {1,5,5,12,3,8};
		System.out.println(subSetSum(nums, 7));
	}

	private static boolean subSetSum(int[] nums, int target)
	{
	   
	   int r = nums.length;
	   int c = target+1;
	   
	   boolean[][] dp = new boolean[r][c];
	   
	   for (int i=0; i<r; i++)
	        dp[i][0] = true;
	   dp[0][nums[0]] = true;
	   
	   for (int i=1; i<r; i++)
	   {
	       for(int j=1; j<c; j++)
	       {
	           dp[i][j] = dp[i-1][j];
	           if (j>=nums[i])
	           {
	               dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
	           }
	       }
	   }
	    
	    
	    return dp[r-1][c-1];
	    
	}
}
