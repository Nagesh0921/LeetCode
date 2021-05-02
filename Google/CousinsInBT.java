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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int queueDepth = q.size();
            boolean siblings = false, cousins = false;
            for(int i=0; i<queueDepth; i++){
                TreeNode node = q.poll();
                
                if(node == null){
                    siblings = false;
                } else {
                    if(node.val == x || node.val == y){
                        if(!cousins){
                            siblings = cousins = true;
                        } else {
                            return !siblings;
                        }
                    }
                    if(node.left != null){
                        q.add(node.left);
                    }
                    if(node.right != null){
                        q.add(node.right);
                    }
                    q.add(null);
                }
            }
            if(cousins) {
                return false;
            }
        }
        return false;
    }
}

//Time Complexity O(N) and Space Complexity O(N)
