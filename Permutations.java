class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            permuteHelper( nums, result, list);
        return result;
    }
    
    void permuteHelper( int[] nums, List<List<Integer>> res, ArrayList<Integer> res1)
    {
      if (res1.size() == nums.length)
      {
          res.add(new ArrayList<Integer>(res1));
          return;
      }
        
        for (int i =0; i<nums.length; i++)
        {
            if (res1.contains(nums[i]))
                continue;
                res1.add(nums[i]);
                permuteHelper( nums, res,res1);
                res1.remove(res1.size()-1);
        }
        
    }
}