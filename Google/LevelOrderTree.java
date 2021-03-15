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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            LinkedList<Integer> list = new LinkedList<>();
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                TreeNode n = q.poll();
                if(n.left != null){
                    q.add(n.left);
                }
                if(n.right != null){
                    q.add(n.right);
                }
                list.add(n.val);
            }
            result.add(list);
        }
        return result;
    }
}

//Time Complexity is O(N) and Space is O(N)
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 39.6 MB, less than 25.65% of Java online submissions for Binary Tree Level Order Traversal.

//If you Obeserve Memory here, it is still more though Space Complexity is O(n)
//If we use DFS we can slightly optimized memory as we dont have to use Queue.
//Basically level order can be treated as "Pre-Order" Traversal

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
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return result;
        }
        levelOrder(root, 0);
        return result;
    }
    
    public void levelOrder(TreeNode node, int level){
        if(result.size() == level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if(node.left != null){
            levelOrder(node.left, level + 1);
        }
        if(node.right != null){
            levelOrder(node.right, level + 1);
        }
    }
}

//Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 39 MB, less than 89.86% of Java online submissions for Binary Tree Level Order Traversal.
