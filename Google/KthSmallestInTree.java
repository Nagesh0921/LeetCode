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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        kthSmallest(root, result);
        return result.get(k-1);
    }
    
    public void kthSmallest(TreeNode n, List<Integer> result){
        if(n == null){
            return;
        }
        kthSmallest(n.left, result);
        result.add(n.val);
        kthSmallest(n.right, result);
    }
}

//Time Complexity O(N) and Space Complexity O(N)
