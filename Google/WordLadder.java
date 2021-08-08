class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        q.add(beginWord);
        int level = 0;
        while(!q.isEmpty()){
            int len = q.size();
            level++;
            for(int i=0; i<len; i++){
                String currWord = q.poll();
                if(currWord.equals(endWord)){
                    return level;
                }
                List<String> neighbors = getNeighbors(currWord);
                for(String neighbor : neighbors){
                    if(words.contains(neighbor)){
                        words.remove(neighbor);
                        q.add(neighbor);
                    }
                }
            }
        }
        return 0;
    }
    
    private List<String> getNeighbors(String s){
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i=0; i<chars.length; i++){
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;
        }
        return result;
    }
}
