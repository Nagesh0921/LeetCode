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
    private int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        longestPath(root);
        return diameter;
    }
    
    public int longestPath(TreeNode node){
        //We will choose Post Order here as value path at Parent Node is important
        if(node == null){
            return 0;
        }
        int leftVal = longestPath(node.left);
        int rightVal = longestPath(node.right);
        //Calculate the longestPath of left and right node at given root
        diameter = Math.max(diameter, leftVal + rightVal);
        
        return Math.max(leftVal, rightVal) + 1;
    }
}

//Time Complexity O(N) and Space Complexity O(N)
