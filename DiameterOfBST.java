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
   
    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
    
        if (root == null)
            return 0;
        maxDepth(root);
        return max;
        
    }
    
    private int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;
        
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(left+right, max);
        return Math.max(left, right) +1;
    }
}
