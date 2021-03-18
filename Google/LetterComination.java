class Solution {
    private Map<Character, String> letters = Map.of('2',"abc",'3',"def",
                                                   '4',"ghi",'5',"jkl",'6',"mno",
                                                   '7',"pqrs",'8',"tuv",'9',"wxyz");
    private List<String> result = new ArrayList<>();
    private String phoneDigits;
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0){
            return result;
        }
        phoneDigits = digits;
        backTrack(0, new StringBuilder());
        return result;
    }
    
    public void backTrack(int index, StringBuilder path){
        if(path.length() == phoneDigits.length()){
            result.add(path.toString());
            return;
        }
        String possibleCombination = letters.get(phoneDigits.charAt(index));
        for(char letter : possibleCombination.toCharArray()){
            path.append(letter);
            backTrack(index+1, path);
            path.deleteCharAt(path.length()-1);
        }
    }
}
