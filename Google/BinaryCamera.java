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
    int ans = 0;
    Set<TreeNode> covered;
    public int minCameraCover(TreeNode root) {
        covered = new HashSet<>();
        covered.add(null);
        treeWalk(root, null);
        return ans;
    }
    
    public void treeWalk(TreeNode node, TreeNode parent){
        if(node != null){
            treeWalk(node.left, node);
            treeWalk(node.right, node);
            
            if(parent == null && !covered.contains(node) || !covered.contains(node.left) || !covered.contains(node.right)){
                ans++;
                covered.add(node);
                covered.add(node.left);
                covered.add(node.right);
                covered.add(parent);
            }
        }
    }
}

//Time Complexity is O(N) and Space Complexity is O(H)
//This is again an example of Greedy Algorithm!!!
