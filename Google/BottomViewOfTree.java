class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        TreeMap<Integer, ArrayList<Integer>> rows = new TreeMap<>();
        Queue<Node> q = new LinkedList<>();
        int rowIndex = 0;
        root.hd = rowIndex;
        q.add(root);
        // q.add(new Pair(root, rowIndex));

        while(!q.isEmpty()){
            // Pair<Node, Integer> p = q.poll();
            // Node node = q.poll()
            Node node =q.poll();
            // rowIndex = p.getValue();
            if(!rows.containsKey(node.hd)){
                rows.put(node.hd, new ArrayList<Integer>());
            }
            rows.get(node.hd).add(node.data);
            // node.hd += 1;
            if(node.left != null){
                node.left.hd = node.hd-1;
                q.offer(node.left);
            }
            if(node.right != null){
                node.right.hd = node.hd+1;
                q.offer(node.right);
            }
        }
        // System.out.println(rows);
        for(Map.Entry<Integer, ArrayList<Integer>> set : rows.entrySet()){
            result.addAll(set.getValue());
        }
        return result;
    }
}

class Pair<K, V>{
    K key;
    V value;
    
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }
}
