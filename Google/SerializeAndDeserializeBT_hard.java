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
        String sb = preOrderDFS(root, "");
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> list = new LinkedList<String>(Arrays.asList(data.split(",")));
        return helperDeserialize(list);
    }
    
    public TreeNode helperDeserialize(List<String> l){
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = helperDeserialize(l);
        root.right = helperDeserialize(l);
        
        return root;
    }
    
    public String preOrderDFS(TreeNode node, String sb){
        if(node == null){
            return sb += "null,";
        } else {
            sb += sb.valueOf(node.val) + ",";
            sb = preOrderDFS(node.left, sb);
            sb = preOrderDFS(node.right, sb);            
        }
        return sb;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

//Time Complexity is O(N) and Space Complexity O(N)
