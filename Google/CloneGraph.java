/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //Understand problem:
    //Cloning Graph as we traverse the graph
    //This could raise following questions -> Unidirected vs Directed
    //In Undirected Graph -> Basically we will get caught into loops A <-> B
    //while visiting node A, we will have B as child list and while visiting B we will have A as child list.
    //To avoid this we need to use Map or Set to avoid getting caught into loops.
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        HashMap<Node, Node> visited = new HashMap<>();
        visited.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            for(Node neighbor : n.neighbors){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
}

//Time Complexity is O(N+M)
