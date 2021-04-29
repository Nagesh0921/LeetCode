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
    private int maxLength = 0;
    public int longestConsecutive(TreeNode root) {
        preOrderTraversal(root, null, 0);
        return maxLength;
    }
    
    private void preOrderTraversal(TreeNode root, TreeNode parentNode, int length){
        if(root == null){
            return;
        }
        length = (parentNode != null && root.val == parentNode.val + 1) ? length+1 : 1;
        maxLength = Math.max(length, maxLength);
        preOrderTraversal(root.left, root, length);
        preOrderTraversal(root.right, root, length);
    }
}
