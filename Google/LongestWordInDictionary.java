class Solution {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        int index = 0;
        for(String word : words){
            trie.insert(word, ++index);
        }
        trie.words = words;
        return trie.dfs();
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    int index;
    
}

class Trie{
    TrieNode root;
    String[] words;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String str, int index){
        TrieNode node = root;
        for(char c : str.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
        }
        node.index = index;
    }
    
    public String dfs(){
        String ans = "";
        Stack<TrieNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TrieNode node = st.pop();
            if(node.index > 0 || node == root){
                if(node != root){
                    String word = words[node.index-1];
                    if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0){
                        ans = word;
                    }
                }
                for(TrieNode n : node.children.values()){
                    st.push(n);
                }
            }
        }
        return ans;
    }
}
