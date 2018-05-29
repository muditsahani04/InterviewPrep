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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        if (root == null || p ==null)
            return null;
        if (p.right == null)
        {
            TreeNode succ = null;
            TreeNode current = root;
            while (current!= null && current.val!= p.val)
            {
                if (p.val < current.val)
                {
                    succ = current;
                    current = current.left;
                }
            else if (p.val > current.val)
                {
                    current = current.right;
                } 
            }
            
            return succ;
            
        }
        else
        {
            return minInRightSubTree(p.right);
        }
    }
    
    private TreeNode minInRightSubTree(TreeNode root)
    {
        if (root.left == null)
            return root;
        
        return  minInRightSubTree(root.left);
    }
    
}
