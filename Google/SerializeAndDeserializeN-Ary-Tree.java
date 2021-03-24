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

class Codec {
    
    class WrappableInt{
        int index;
        WrappableInt(int index){
            this.index = index;
        }
        public int getIndex(){
            return this.index;
        }
        public void increment(){
            this.index++;    
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    public void serializeHelper(Node node, StringBuilder sb){
        if(node == null){
            return;
        }
        sb.append((char) (node.val + '0'));
        
        for(Node n : node.children){
            serializeHelper(n, sb);
        }
        sb.append("#");
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        return deserializeHelper(data, new WrappableInt(0));
    }
    
    public Node deserializeHelper(String data, WrappableInt index){
        if(index.getIndex() == data.length()){
            return null;
        }
        
        Node node = new Node(data.charAt(index.getIndex()) - '0', new ArrayList<Node>());
        index.increment();
        while(data.charAt(index.getIndex()) != '#'){
            node.children.add(deserializeHelper(data, index));
        }
        index.increment();
        
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


//Time Complexity is O(N) and Space Complexity is O(N)
