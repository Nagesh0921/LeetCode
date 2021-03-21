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
    List<TreeNode> newRoot;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int len = to_delete.length;
        newRoot = new ArrayList<>();
        if(len == 0){
            return newRoot;
        }
        HashSet<Integer> toBeDeleted = new HashSet<>();
        for(int val : to_delete){
            toBeDeleted.add(val);
        }
        if(!toBeDeleted.contains(root.val)){
            newRoot.add(root);
        }
        postOrderDFS(root, toBeDeleted);
        return newRoot;
    }
    
    public TreeNode postOrderDFS(TreeNode root, HashSet<Integer> toBeDeleted){
        if(root == null){
            return root;
        }
        root.left = postOrderDFS(root.left, toBeDeleted);
        root.right = postOrderDFS(root.right, toBeDeleted);
        if(toBeDeleted.contains(root.val)){
            if(root.left != null){
                newRoot.add(root.left);
            } 
            if(root.right != null) {
                newRoot.add(root.right);
            }
            return null;
        }
        return root;
    }
}

//Time Complexity O(N) and Space Complexity O(N)
