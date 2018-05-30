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
        if (s == null)
            return checkIfsame(s,t);
       boolean res = checkIfsame(s,t) ;
       if (res)
           return true;
       else
           return inOrder(s.left, t) || inOrder(s.right, t);
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
