import java.util.*;
public class TrieSample1 {
    TrieNode1 root = null;

    public TrieSample1(){
        root = new TrieNode1();
    }

    public static void main(String[] args) {
        TrieSample1 sample = new TrieSample1();
        sample.insert("apple");
        sample.insert("apply");
        sample.insert("activate");
        sample.insert("active");
        List<String> res = sample.search("apc");
        for(String s : res){
            System.out.println(s);
        }
    }

    public void insert(String s){
        TrieNode1 node = root;
        for(Character c : s.toCharArray()){
            if(!node.children.containsKey(c)){
                node.children.put(c, new TrieNode1());
            }
            node = node.children.get(c);
        }
        node.isWord = true;
        node.word = s;
    }

    public List<String> search(String s){
        TrieNode1 node = root;
        for(Character c : s.toCharArray()){
            if(!node.children.containsKey(c)){
                return new ArrayList<>();
            }
            node  = node.children.get(c);
        }
        List<String> result = new ArrayList<>();
        traverse(result, node);
        return result;
    }

    public void traverse(List<String> res, TrieNode1 node){
        for(Character c : node.children.keySet()){
            TrieNode1 n = node.children.get(c);
            if(!n.isWord){
                traverse(res, n);
            } else {
                res.add(n.word);
            }
        }
        
    }
}

class TrieNode1{
    HashMap<Character, TrieNode1> children;
    boolean isWord = false;
    String word;

    public TrieNode1(){
        children = new HashMap<Character, TrieNode1>();
    }
}
