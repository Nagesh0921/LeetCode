class Solution {
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }
    
    public String build(String s){
        Stack<Character> c = new Stack<>();
        for(Character ch : s.toCharArray()){
            if(ch != '#'){
                c.push(ch);
            } else {
                if(!c.isEmpty()){
                    c.pop();
                }
            }
        }
        return String.valueOf(c);
    }
}

//Time Complexity O(N+M)
