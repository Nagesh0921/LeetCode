class AutocompleteSystem {

    private TrieNode root;
    private String cur_string = "";
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        for(int i=0; i<sentences.length; i++){
            createTrie(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c == '#'){
            createTrie(cur_string, 1);
            cur_string = "";
        } else {
            cur_string += c; 
            List<Node> list = lookup(cur_string);
            Collections.sort(list, (a,b)-> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for(int i=0; i<Math.min(3, list.size()); i++){
                res.add(list.get(i).sentence);
            }
        }
        return res;
    }
    
    public void createTrie(String s, int times){
        TrieNode node = root;
        for(int i=0; i<s.length(); i++){
            if(!node.children.containsKey(s.charAt(i))){
                TrieNode newNode = new TrieNode();
                newNode.noOfTimes += times;
                node.children.put(s.charAt(i), newNode);
            }
            node = node.children.get(s.charAt(i));
        }
        node.noOfTimes += times;
        node.isWord = true;
    }
    
    public List<Node> lookup(String s){
        List<Node> list = new ArrayList<>();
        TrieNode node = root;
        for(int i=0; i<s.length(); i++){
            if(!node.children.containsKey(s.charAt(i))){
                return new ArrayList<>();
            }
            node = node.children.get(s.charAt(i));
        }
        traverse(node, list, s);
        return list;
    }
    
    public void traverse(TrieNode node, List<Node> list, String s){
        for(char c : node.children.keySet()){
            TrieNode n = node.children.get(c);
            if(n.isWord){
                StringBuilder st = new StringBuilder(s);
                list.add(new Node(st.toString()+c, n.noOfTimes));
            } else {
                traverse(n, list, s+c);
            }
        }
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    int noOfTimes;
    boolean isWord;
    
    public TrieNode(){
        children = new HashMap<>();
        noOfTimes = 0;
    }
}

//As Trie contains only Characters we can build helper node to return back the string.
class Node{
    String sentence;
    int times;
    
    Node(String sentence, int times){
        this.sentence = sentence;
        this.times = times;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

//Time Complexity 
//Create Trie O(n*L) -> n: no of strings and l is length of each string
//Input O(p + q + mLogN)
