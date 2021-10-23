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
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        this.result = new ArrayList<>();
        
        getHeight(root);
        
        return this.result;
    }
    
    private int getHeight(TreeNode node){
        if(node == null){
            return -1;
        }
        
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        
        int currHeight = Math.max(leftHeight, rightHeight) + 1;
        
        if(this.result.size() == currHeight){
            this.result.add(new ArrayList<>());
        }
        this.result.get(currHeight).add(node.val);
        
        return currHeight;
    }
}

//Time Complexity -> O(N)
