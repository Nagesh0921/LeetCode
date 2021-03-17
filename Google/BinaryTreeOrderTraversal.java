/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node first=null, last=null;
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }
        inOrderTraversal(root);
        last.right = first;
        first.left = last;
        return first;
    }
    
    public void inOrderTraversal(Node n){
        if(n != null){
            inOrderTraversal(n.left);
            if(last != null){
                n.left = last;
                last.right = n;
            } else {
                first = n;
            }
            last = n;
            inOrderTraversal(n.right);
        }
    }
}

//Time Complexity O(N) and Space Complexity O(N)
