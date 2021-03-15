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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode node = q.poll();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
                if((level&1) == 0){
                    list.add(node.val);    
                } else {
                    list.addFirst(node.val);
                }
            }
            result.add(list);
            level++;
        }
        return result;
    }
}

//Time Complexity is O(N) and Space Complexity O(N) as we will traverse All the nodes once.
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
//Memory Usage: 38.7 MB, less than 96.30% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
