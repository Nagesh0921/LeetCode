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
    private Queue<int[]> nodeEntries;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        nodeEntries = new PriorityQueue<>((e1, e2) -> {
            for(int i=0; i<e1.length; i++){
                if(e1[i] != e2[i]){
                    return e1[i] - e2[i];
                }
            }
            return 0;
        });
        dfsRecurse(root, 0, 0);
        // for(int i=0; i<nodeEntries.size(); i++){
        //     int[] k = nodeEntries.poll();
        //     System.out.println(k[0]+" "+k[1]+" "+k[2]);
        // }
        List<List<Integer>> result = new ArrayList<>();
        int currentCol = Integer.MIN_VALUE;
        while(!nodeEntries.isEmpty()){
            int[] entry = nodeEntries.remove();
            if(entry[0] != currentCol){
                currentCol = entry[0];
                result.add(new ArrayList<>());
            }
            result.get(result.size()-1).add(entry[2]);
        }
        return result;
    }
    
    private void dfsRecurse(TreeNode node, int col, int row){
        if(node == null){
            return;
        }
        nodeEntries.add(new int[]{col, row, node.val});
        dfsRecurse(node.left, col-1, row+1);
        dfsRecurse(node.right, col+1, row+1);
    }
}

//Time Complexity is O(N) and Space Complexity is O(N)
