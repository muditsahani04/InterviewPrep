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
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null)
            return true;
        else
        {
            if (root.left == null )
            {
                if (root.val < minInRightSubTree(root.right)  && isValidBST(root.right)  )
                    return true;
            }
            else if (root.right == null )
            {
                if (root.val > maxInLeftSubTree(root.left) && isValidBST(root.left) )
                    return true;
            }
            else 
            {
                if (maxInLeftSubTree(root.left) < root.val && root.val < minInRightSubTree(root.right) && isValidBST(root.left) && isValidBST(root.right))
                    return true;
            }
    
        }
        return false;
    }
    
    private int maxInLeftSubTree(TreeNode n)
    {
        if (n == null)
            return Integer.MIN_VALUE;
        if (n.right == null)
            return n.val;
        else 
            return (Math.max(n.right.val,maxInLeftSubTree(n.right)));
        
    }
    private int minInRightSubTree(TreeNode n)
    {
        if (n == null)
            return Integer.MAX_VALUE;
        if (n.left == null)
            return n.val;
        else 
            return (Math.min(n.left.val,minInRightSubTree(n.left)));
        
    }
}