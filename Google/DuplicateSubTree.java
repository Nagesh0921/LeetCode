/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    HashMap<String, Integer> map;
    List<TreeNode> result;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        result = new ArrayList<>();
        serialize(root);
        return result;
    }
    
    public String serialize(TreeNode node){
        if(node == null){
            return "#";
        }
        String serializedStr = node.val + "," + serialize(node.left) + "," + serialize(node.right);
        map.put(serializedStr, map.getOrDefault(serializedStr, 0) + 1);
        if(map.get(serializedStr) == 2){
            result.add(node);
        }
        return serializedStr;
    }
}

//Time Complexity O(N^2) due to creation "serializedStr" same for Space
//Runtime: 20 ms, faster than 63.25% of Java online submissions for Find Duplicate Subtrees.
//Memory Usage: 44.4 MB, less than 50.49% of Java online submissions for Find Duplicate Subtrees.



