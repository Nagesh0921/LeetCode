class Solution {
    
    TrieNode root = new TrieNode();
    List<String> result = new ArrayList<>();
    
    public void constructTrie(String[] words){
        
        for(String word : words){
            TrieNode node = root;
            for(int i=0; i<word.length(); i++){
                if(!node.children.containsKey(word.charAt(i))){
                    TrieNode newNode = new TrieNode();
                    node.children.put(word.charAt(i), newNode);
                    node = newNode;
                } else {
                    node = node.children.get(word.charAt(i));
                }
            }
            node.word = word;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        constructTrie(words);
        int rows = board.length, cols = board[0].length;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(root.children.containsKey(board[r][c])){
                    backtrack(board, root, r, c);
                }
            }
        }
        return result;
    }
    
    public void backtrack(char[][] board, TrieNode node, int row, int col){
        Character ch = board[row][col];
        TrieNode current = node.children.get(ch);
        if(current.word != null){
            result.add(current.word);
            current.word = null;
        }
        
        board[row][col] = '#';
        
        //Directions to roam within board
        int[] rowDir = {-1, 0, 1, 0};
        int[] colDir = {0, 1, 0, -1};
        
        //Robot Clean Grid - This loop is for Directions
        for(int i=0; i<4; i++){
            int newRow = row + rowDir[i];
            int newCol = col + colDir[i];
            if(newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length){
                continue;
            }
            if(current.children.containsKey(board[newRow][newCol])){
                backtrack(board, current, newRow, newCol);
            }
        }
        board[row][col] = ch;
        
        if(current.children.isEmpty()){
            node.children.remove(ch);
        }
    }
}

class TrieNode{
    HashMap<Character, TrieNode> children;
    String word;
    public TrieNode(){
        children = new HashMap<>();
    }
}

//Time Complexity is O(M*(4*3^l-1))
// M : no of cells in the grid
// 4 - directions we can move
// 3 - neighboring words that we can visit
// l - length of the word

// Space Complexity is O(N)
