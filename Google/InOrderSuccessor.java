/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode result = null;
        
        while(root != null){
            if(p.val >= root.val) {
                root = root.right;
            } else {
                result = root;
                root = root.left;    
            }
        }
        return result;
    }
}

//Time Complexity O(N) if tree is very bad huge, in balanced binary tree it will be O(logN)
//Space Complexity O(1)
