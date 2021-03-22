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
        StringBuilder sb = postOrder(root, new StringBuilder());
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(String s : data.split("\\s+")){
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }
    
    public TreeNode helper(int lowerVal, int upperVal, ArrayDeque<Integer> nums){
        if(nums.isEmpty()){
            return null;
        }
        int val = nums.getLast();
        if(val < lowerVal || val > upperVal){
            return null;
        }
        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upperVal, nums);
        root.left = helper(lowerVal, val, nums);
        return root;
    }
    
    public StringBuilder postOrder(TreeNode node, StringBuilder sb){
        if(node == null){
            return sb;
        }
        postOrder(node.left, sb);
        postOrder(node.right, sb);
        sb.append(node.val);
        sb.append(' ');
        return sb;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
