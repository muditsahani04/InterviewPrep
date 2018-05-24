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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return inOrder(s, t);
    }
    
    private boolean inOrder(TreeNode s, TreeNode t)
    {
        boolean res= false;
        if (s == null)
            return checkIfsame(s,t);
        if ( s.val == t.val)
        {
          res = checkIfsame (s,t);
        }
        
        if (res)
            return true;
        else
        {
            res = inOrder(s.left, t);
            if (res)
                return true;
            else
             return inOrder(s.right, t);  
        }
    }
    
    private boolean checkIfsame (TreeNode s, TreeNode t)
    {
        if (t == null && s==null )
                return true;
        if (s == null || t==null)  
            return false;
        if (s.val != t.val )
            return false;
        else  
            return checkIfsame(s.left, t.left) && checkIfsame(s.right, t.right); 
    }
}