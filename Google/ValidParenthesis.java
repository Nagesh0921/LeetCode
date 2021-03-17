class Solution {
    public boolean isValid(String s) {
        if(s.length() <= 1 || s == null){
            return false;
        }
        Stack<Character> st = new Stack<>();
        int len = s.length();
        if((len&1) > 0){
            return false;
        }
        for(int i=0; i<len; i++){
            switch(s.charAt(i)){
                case '[','{','(': st.push(s.charAt(i));
                    break;
                case ')': if(!st.isEmpty() && st.peek() == '('){
                            st.pop();
                        } else {
                            return false;
                        }
                    break;
                case ']':if(!st.isEmpty() && st.peek() == '['){
                            st.pop();
                        } else {
                            return false;
                        }
                    break;
                case '}':if(!st.isEmpty() && st.peek() == '{'){
                            st.pop();
                        } else {
                            return false;
                        }
                    break;
            }
        }
        return (st.isEmpty()) ? true : false;
    }
}

//Time Complexity O(n) Space Complexity O(N) for cases of odd lengths strings Space is O(1)
//Runtime: 1 ms, faster than 98.63% of Java online submissions for Valid Parentheses.
//Memory Usage: 37 MB, less than 86.02% of Java online submissions for Valid Parentheses.
