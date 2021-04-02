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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Codec {
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        Pair<TreeNode, Node> head = new Pair<TreeNode, Node>(newRoot, root);
        
        Queue<Pair<TreeNode, Node>> q = new ArrayDeque<Pair<TreeNode, Node>>();
        q.add(head);
        while(!q.isEmpty()){
            Pair<TreeNode, Node> pair = q.remove();
            TreeNode tNode = pair.first;
            Node nNode = pair.second;
            
            TreeNode prevBNode = null, headBNode = null;
            for(Node n : nNode.children){
                TreeNode newBNode = new TreeNode(n.val);
                if(prevBNode == null){
                    headBNode = newBNode;
                } else {
                    prevBNode.right = newBNode;
                }
                prevBNode = newBNode;
                
                Pair<TreeNode, Node> nextEntry = new Pair<TreeNode, Node>(newBNode, n);
                q.add(nextEntry);
            }
            
            tNode.left = headBNode;
        }
        return newRoot;
    }
	
    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null){
            return null;
        }
        Node newRoot = new Node(root.val, new ArrayList<Node>());
        Pair<Node, TreeNode> head = new Pair<Node, TreeNode>(newRoot, root);
        Queue<Pair<Node, TreeNode>> q = new ArrayDeque<Pair<Node, TreeNode>>();
        q.add(head);
        
        while(!q.isEmpty()){
            Pair<Node, TreeNode> entry = q.remove();
            Node nNode = entry.first;
            TreeNode tNode = entry.second;
            
            TreeNode firstChild = tNode.left;
            TreeNode siblings = firstChild;
            
            while(siblings != null){
                Node nChild = new Node(siblings.val, new ArrayList<Node>());
                nNode.children.add(nChild);
                
                Pair<Node, TreeNode> nextEntry = new Pair<Node, TreeNode>(nChild, siblings);
                q.add(nextEntry);
                siblings = siblings.right;
            }
            
        }
        return newRoot;
    }
}

class Pair<U, V>{
    public U first;
    public V second;
    
    public Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(root));
