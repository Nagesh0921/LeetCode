class WordDictionary {

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(!node.children.containsKey(ch)){
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchInNode(word, root);
    }
    
    public boolean searchInNode(String word, TrieNode node){
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            if(node.children.containsKey(ch)){
                node = node.children.get(ch);
            } else {
                if(ch == '.'){
                    for(char n : node.children.keySet()){
                        TrieNode child = node.children.get(n);
                        if(searchInNode(word.substring(i+1), child)){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return node.isEnd;
    }
}

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEnd;
    TrieNode(){
        children = new HashMap<>();
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

//Time Complexity to Insert O(M) => M is length of the word Space Complexity is Same
// Time Complexity of Search is O(M)
