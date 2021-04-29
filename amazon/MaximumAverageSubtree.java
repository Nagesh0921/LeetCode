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
    public double maximumAverageSubtree(TreeNode root) {
        return maxAverage(root).maxAverage;
    }
    
    State maxAverage(TreeNode root){
        
        if(root == null){
            return new State(0,0,0);
        }
        
        State leftNode = maxAverage(root.left);
        State rightNode = maxAverage(root.right);
        
        int nodeCount = leftNode.nodeCount + rightNode.nodeCount + 1;
        int sum = leftNode.nodeSum + rightNode.nodeSum + root.val;
        double maxAverage = Math.max((1.0 * sum)/nodeCount, Math.max(leftNode.maxAverage, rightNode.maxAverage));
        
        return new State(nodeCount, maxAverage, sum);
    }
    
    class State{
        int nodeCount;
        double maxAverage;
        int nodeSum;
        
        State(int nodeCount, double maxAverage, int nodeSum){
            this.nodeCount = nodeCount;
            this.maxAverage = maxAverage;
            this.nodeSum = nodeSum;
        }
    }
}

//Time Complexity O(N) and Space Complexity O(N)
