/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder res = new StringBuilder();
        constructString(root,res);
        return res.toString();
     }
    
    private void constructString(TreeNode root,StringBuilder res)
    {
        if (root == null)
        {
            res.append("#").append(",");
            return;
        }
        
        res.append(root.val).append(",");
        constructString(root.left,res);
        constructString(root.right,res);
            
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       Queue<String> nodes = new LinkedList<String>(Arrays.asList(data.split(",")));
       return constructTree(nodes);
       
    }
    
    private TreeNode constructTree( Queue<String>  nodes)
    {
        String val = nodes.poll();
        if ( val.equals("#"))
            return null;
        else
        {
             TreeNode root = new TreeNode(Integer.valueOf(val));
             root.left = constructTree(nodes);
            root.right = constructTree(nodes);
            return root;
        }
       
       
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));