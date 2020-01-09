
public class ContainerWithMostWater {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] input = new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(input));
	}
	
	public static int maxArea(int[] height)
	{
		int maxArea = 0;
		int left = 0, right = height.length-1, curArea = 0;
		
		while (left<right)
		{
			curArea = Math.min(height[left], height[right])*(right-left);
			maxArea = Math.max(maxArea,curArea);
			
			int curLeftHeight = height[left];
			int curRightHeight = height[right];
			
			if (curLeftHeight < curRightHeight)
			{
				while (left<right && height[left] <= curLeftHeight) left++;
			}
			else
			{
				while (right > left && height[right]<= curRightHeight) right--;
			}
			
		}
		return maxArea;
	}

}
