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
    public boolean isCompleteTree(TreeNode root) {
        List<Node> list = new ArrayList<>();
        list.add(new Node(root, 1));
        int i=0;
        while(i < list.size()){
            Node n = list.get(i++);
            if(n.node != null){
                list.add(new Node(n.node.left, n.code * 2));
                list.add(new Node(n.node.right, (n.code * 2) + 1));
            }
        }
        return list.size() == list.get(i-1).code;
    }
}

class Node{
    TreeNode node;
    int code;
    
    Node(TreeNode node, int code){
        this.node = node;
        this.code = code;
    }
}

//Time Complexity is O(N)
