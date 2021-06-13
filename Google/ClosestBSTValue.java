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
    private int min_value = Integer.MAX_VALUE;
    private double diff = Double.MAX_VALUE;
    public int closestValue(TreeNode root, double target) {
        //In case of Binary Seach we can always choose BS algo to search element
        //For Brute Force, we can traverse the tree and update min element
        inorder(root, target);
        return min_value;
    }
    
    private void inorder(TreeNode node, double target){
        if(node == null){
            return;
        }
        inorder(node.left, target);
        if(Math.abs(target - node.val) < diff){
            diff = Math.abs(target - node.val);
            min_value = node.val;
        }
        inorder(node.right, target);
    }
}

//Time Complexity O(N) and Space Complexity is O(1)
