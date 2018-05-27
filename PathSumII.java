/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        helper(res, root, sum, new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, TreeNode root, int sum, List<Integer> path)
    {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
        {
            
            if (sum == root.val)
            {
                path.add(root.val);
                res.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);
            }
                
            return;
        }
        
        
        helper(res, root.left, sum - root.val, path);
        helper(res, root.right, sum - root.val, path);
        path.remove(path.size()-1);
        
        return;
    }
}