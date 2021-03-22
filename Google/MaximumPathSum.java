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
    private int maxVal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxVal;
    }
    
    public int maxSum(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftVal = Math.max(maxSum(node.left), 0);
        int rightVal = Math.max(maxSum(node.right), 0);
        
        int newValAtNode = node.val + leftVal + rightVal;
        maxVal = Math.max(maxVal, newValAtNode);
        
        return node.val + Math.max(leftVal, rightVal);
    }
}
