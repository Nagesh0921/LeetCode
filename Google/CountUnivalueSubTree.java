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
    //All Nodes of Subtree, hence we can not use HashMap to store the count of Node values
    //Hence DFS
    int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null){
            return 0;
        }
        preorder(root);
        return count;
    }
    
    //we need a counter to count the same value nodes
    private boolean preorder(TreeNode node){
        
        //End Of Tree -> Smallest SubTree
        if(node.left == null && node.right == null){
            count++;
            return true;
        }
        
        boolean isValid = true;
        
        if(node.left != null){
            isValid = preorder(node.left) && isValid && node.left.val == node.val;
        }
        
        if(node.right != null){
            isValid = preorder(node.right) && isValid && node.right.val == node.val;
        }
        
        if(isValid){
            count++;
            return true;
        }
        
        return false;
    }
}

//Time Complexity -> O(N)
//Space Complexity -> O(H) height of Tree
