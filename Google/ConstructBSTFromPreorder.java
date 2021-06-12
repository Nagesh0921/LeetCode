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
    private int[] preorder;
    int length, index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null){
            return null;
        }
        this.preorder = preorder;
        this.length = preorder.length;
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode helper(int lowerBound, int upperBound){
        if(index == length){
            return null;
        }
        int val = preorder[index];
        if(val < lowerBound || val > upperBound){
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);
        root.left = helper(lowerBound, val);
        root.right = helper(val, upperBound);
        return root;
    }
}
