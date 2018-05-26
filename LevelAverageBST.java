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
    public List<Double> averageOfLevels(TreeNode root) {
        
        
        List<Double> res = new ArrayList<Double>();
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        double sum = 0.0;
        int count = 0;
        while(!q.isEmpty())
        {
            TreeNode front = q.poll();
            if (front != null)
            {
                sum += front.val;
                count++;
                if (front.left!=null)
                    q.add(front.left);
                    
                if (front.right!=null)
                    q.add(front.right);
            }
            else
            {
                res.add(sum/count);
                sum=0.0;
                count = 0;
                if (!q.isEmpty())
                    q.add(null);
            }
        }
        
        return res;
    }
}