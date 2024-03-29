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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        if(heightOfTree(root.left) - heightOfTree(root.right) > 1){
            return false;
        }
        return Math.abs(heightOfTree(root.left) - heightOfTree(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int heightOfTree(TreeNode node){
        if(node == null){
            return -1;
        }
        return 1 + Math.max(heightOfTree(node.left), heightOfTree(node.right));
    }
}
