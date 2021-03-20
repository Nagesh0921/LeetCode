class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> elements = new HashMap<>();
        for(String s : words){
            elements.put(s, elements.getOrDefault(s, 0)+1);
        }
        WordFrequency[] orderedWord = new WordFrequency[elements.size()];
        int pos = 0;
        for(Map.Entry<String, Integer> entry : elements.entrySet()){
            orderedWord[pos++] = new WordFrequency(entry.getKey(), entry.getValue());
        }
        Arrays.sort(orderedWord);
        ArrayList<String> res = new ArrayList<>();
        for(int i=0; i< k; i++){
            res.add(orderedWord[i].s);
        }
        return res;
    }
}

class WordFrequency implements Comparable<WordFrequency>{
    String s;
    int frequency;
    WordFrequency(String s, int frequency){
        this.s = s;
        this.frequency = frequency;
    }
    
    public int compareTo(WordFrequency wf){
        if(this.frequency == wf.frequency) {
            return this.s.compareTo(wf.s);
        } else if(this.frequency < wf.frequency) {
            return 1;
        } else {
            return -1;
        }
    }
}

//Time Complexity O(k*nLogN) Space Complexity O(N+K)
