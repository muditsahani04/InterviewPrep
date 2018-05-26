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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = null;
        
        return helper(root, t1, t2);
    }
    
    private TreeNode helper(TreeNode root, TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null)
            return null;
        else if (t1 ==null || t2 == null)
            return t1== null ? t2:t1;
        else
            root = new TreeNode(t1.val + t2.val);
        
            root.left = helper(root.left, t1.left , t2.left);
            root.right = helper(root.right,t1.right, t2.right);
        return root;
    }
}