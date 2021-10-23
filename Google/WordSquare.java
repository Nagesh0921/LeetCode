class Solution {
    HashMap<String, List<String>> dictionary;
    //As constraint stated, all words in inputs will have same length
    int numberOfWord = 0;
    public List<List<String>> wordSquares(String[] words) {
        this.numberOfWord = words[0].length();
        List<List<String>> result = new ArrayList<>();
        
        prefixDictionary(words);
        for(String word : words){
            LinkedList<String> wordList = new LinkedList<>();
            wordList.addLast(word);
            backtrack(wordList, result, 1);
        }
        
        return result;
    }
    
    private void prefixDictionary(String[] words){
        this.dictionary = new HashMap<>();
        for(String word : words){
            //This Step basically creates a Map of
            // b->ball, ba->ball, bal->ball, ball->ball
            //this helps in backtracking
            for(int i=0; i<this.numberOfWord; i++){
                String prefix = word.substring(0, i);
                if(this.dictionary.containsKey(prefix)){
                    this.dictionary.get(prefix).add(word);
                } else {
                    List<String> wordList = new ArrayList<>();
                    wordList.add(word);
                    this.dictionary.put(prefix, wordList);
                }
            }
        }
    }
    
    private List<String> getPrefixString(String prefix){
        List<String> wordList = this.dictionary.get(prefix);
        return (wordList != null) ? wordList : new ArrayList<>();
    }
    
    private void backtrack(LinkedList<String> wordList, List<List<String>> result, int step){
        if(step == this.numberOfWord){
            result.add((List<String>)wordList.clone());
            return;    
        }
        
        StringBuilder sb = new StringBuilder();
        //Basically we are trying to get next candidate, in backtracking
        //ball -> 'a'
        for(String w : wordList){
            sb.append(w.charAt(step));
        }
        
        //Get all eligible candidates from Dictionary
        for(String word : getPrefixString(sb.toString())){
            wordList.addLast(word);
            backtrack(wordList, result, step+1);
            wordList.removeLast();
        }
    }
}

//As we need multiple combinations from inputs, classic Backtracking
//Time Complexity -> creating map of every possible combination of inputs, so worst case would be 26^L
//Entirely -> N * 26^L
