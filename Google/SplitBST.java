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
    public TreeNode[] splitBST(TreeNode root, int V) {
        if(root == null){
            return new TreeNode[]{null, null};
        } else if(root.val <= V) {
            TreeNode[] split = splitBST(root.right, V);
            root.right = split[0];
            split[0] = root;
            return split;
        } else {
            TreeNode[] split = splitBST(root.left, V);
            root.left = split[1];
            split[1] = root;
            return split;
        }
    }
}
