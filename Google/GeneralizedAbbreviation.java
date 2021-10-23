class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, word);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder sb, int curPos, int consChars, String word){
        int len = sb.length();
        if(curPos == word.length()){
            if(consChars != 0){
                sb.append(consChars);
            }
            result.add(sb.toString());
        } else {
            backtrack(result, sb, curPos+1, consChars+1, word);
            if(consChars != 0){
                sb.append(consChars);
            }
            sb.append(word.charAt(curPos));
            backtrack(result, sb, curPos+1, 0, word);
        }
        sb.setLength(len);
    }
}
