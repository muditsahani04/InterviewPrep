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
        int sum = helper(root.left) + helper(root.right);
        if ( sum > max)
            max = sum;
        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);
        
        return max;
    }
    
    private int helper(TreeNode root)
    {
        if (root == null)
            return 0;
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        return Math.max(left,right)+1;
    }
}