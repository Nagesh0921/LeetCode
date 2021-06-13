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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Integer> rightSideView = new ArrayList<>();
        while(!q.isEmpty()){
            int level = q.size();
            for(int i=0; i<level; i++){
                TreeNode n = q.poll();
                if(i == level-1){
                    rightSideView.add(n.val);
                }
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
            }
        }
        return rightSideView;
    }
}

//using DFS
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
    List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return result;
        }
        rightView(root, 0);
        return result;
    }
    
    private void rightView(TreeNode node, int level){
        if(level == result.size()){
            result.add(node.val);
        }
        if(node.right != null){
            rightView(node.right, level+1);
        }
        if(node.left != null){
            rightView(node.left, level+1);
        }
    }
}
