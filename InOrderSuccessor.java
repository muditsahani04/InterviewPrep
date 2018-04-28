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
       
        return inOrderHelper(root,p,root);
    }
    
    private TreeNode inOrderHelper(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == null)
            return null;
        if (root == p)
        {
            if (root.right == null)
            {
                if ( q.val > root.val )
                    return q;
                else
                    return null;
            }
            else 
            {
                return minInRightSubTree(root.right);
                
            }
        }
        
        if (p.val < root.val)
        {
            q =  root;
            return inOrderHelper(root.left, p, q);
        }
        else
        {
            
            return inOrderHelper(root.right, p, q);
        }
    }
    
    private TreeNode minInRightSubTree(TreeNode root)
    {
        if ( root.left != null)
            return minInRightSubTree(root.left);
        return root;
        
    }
}