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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if (root == null)
            return res;
        
        helper(res,new StringBuilder(),root);
        return res;
    }
    
    private void helper(List<String> res, StringBuilder path, TreeNode root)
    {
        
        if (root == null)
            return;
        if (root.left == null && root.right == null)
        {
            path.append(root.val);
            res.add(path.toString());
            path.delete(path.lastIndexOf(""+(root.val)), path.length());
            return;
        }
           
            path.append(root.val);
            path.append("->");
            helper(res,path,root.left);
            helper(res,path,root.right);
            path.delete(path.lastIndexOf(""+(root.val)), path.length());
           
        return;
    }
}
