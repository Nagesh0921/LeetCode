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


//In Serialization the demiliter is important
//hence it can be Wrapper Class -> Integer
//Instead Of Dealings with String which costly operations.
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
        StringBuilder sb = new StringBuilder();
        List<Integer> ser = new ArrayList<>();
        preorder(root, ser);
        for(Integer n : ser){
            System.out.println(n);
        }
        sb = preorder(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    //1,2,3,null,null,4,5,null,null,null,null,
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return helperDeserialize(nodes);
    }
    
    private TreeNode helperDeserialize(List<String> l){
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
    
    private StringBuilder preorder(TreeNode node, StringBuilder sb){
        if(node == null){
            return sb.append("null,");
        }
        sb.append(node.val).append(",");
        preorder(node.left, sb);
        preorder(node.right, sb);
        return sb;
    }
    
    private void preorder(TreeNode node, List<Integer> ser){
        if(node == null){
            ser.add(null);
            return;
        }
        ser.add(node.val);
        preorder(node.left, ser);
        preorder(node.right, ser);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
