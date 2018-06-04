class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i = 0;
        int max = 0;
        while(i< heights.length)
        {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i])
            {
                stack.push(i);
                i++;
            }
            else
            {
                int currMax = stack.pop();
                int area = heights[currMax]*(stack.isEmpty()? i : (i-1-stack.peek()));
                max = Math.max(area,max);
            }
        }
        
        while(!stack.isEmpty())
        {
            int currMax = stack.pop();
                int area = heights[currMax]*(stack.isEmpty()? i : (i-1-stack.peek()));
                max = Math.max(area,max);
        }
        
        return max;
    }
}