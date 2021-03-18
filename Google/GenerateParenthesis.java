class Solution {
    ArrayList<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n,"");
        return result;
    }
    
    public void backtrack(int openIndex, int closeIndex, int maxCombinationLeft, String s){
        if(s.length() == maxCombinationLeft*2){
            result.add(s.toString());
            return;
        }
        if(openIndex < maxCombinationLeft){
            backtrack(openIndex+1, closeIndex, maxCombinationLeft, s+"(");
        }
        if(closeIndex < openIndex){
            backtrack(openIndex, closeIndex+1, maxCombinationLeft, s+")");
        }
    }
}
