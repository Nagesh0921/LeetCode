/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null){
            return result;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int qSize = q.size();
            for(int i=0; i<qSize; i++){
                Node n = q.poll();
                for(Node child : n.children){
                    q.add(child);
                }
                temp.add(n.val);
            }
            result.add(temp);
        }
        return result;
    }
}
