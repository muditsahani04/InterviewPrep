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
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        
        traverse(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
       /* List<TreeNode> list = new ArrayList<TreeNode>();
        inOrder(root, list);
        
        List<TreeNode> list2 = new ArrayList<TreeNode>(list);
        
        Collections.sort(list2, new Comparator<TreeNode> (){
            
            public int compare(TreeNode n1, TreeNode n2)
            {
                return n1.val - n2.val;
            }
        });              
          
        for (int i=0; i<list.size(); i++)
        {
            if (list.get(i).val != list2.get(i).val)
            {
                int temp = list.get(i).val;
                list.get(i).val = list2.get(i).val;
                list2.get(i).val = temp;
                break;
            }
        } */
    }
    
    public void inOrder(TreeNode root, List<TreeNode> inOrderList)
    {
        if (root == null)
            return;
        TreeNode temp = root;
        inOrder(temp.left, inOrderList);
        inOrderList.add(temp);
        inOrder(temp.right, inOrderList);
    }
    
    public void traverse(TreeNode root)
    {
        if (root == null)
            return;
        traverse(root.left);
        if (first == null && prev.val >= root.val)
            first = prev;
        if (first != null && prev.val >= root.val)
            second = root;
        
        prev = root;
        
        traverse(root.right);
    }
    
}