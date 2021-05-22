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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathLists = new ArrayList<>();
        List<Integer> pathNodes = new ArrayList<>();
        recurse(root, targetSum, pathNodes, pathLists);
        return pathLists;
    }
    
    private void recurse(TreeNode node, int sum, List<Integer> pathNodes, List<List<Integer>> pathLists){
        if(node == null){
            return;
        }
        
        pathNodes.add(node.val);
        
        if(sum == node.val && node.left == null && node.right == null){
            pathLists.add(new ArrayList<>(pathNodes));
        } else {
            recurse(node.left, sum-node.val, pathNodes, pathLists);
            recurse(node.right, sum-node.val, pathNodes, pathLists);
        }
        
        pathNodes.remove(pathNodes.size()-1);
    }
}

//Time Complexity is O(LogN)
