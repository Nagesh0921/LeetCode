class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> string = new Stack<>();
        StringBuilder str = new StringBuilder();
        int k=0;
        for(Character ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                k = k*10+ch - '0';
            } else if(ch == '['){
                count.push(k);
                string.push(str);
                str = new StringBuilder();
                k=0;
            } else if(ch == ']'){
                StringBuilder decode = string.pop();
                for(int i=count.pop(); i>0; i--){
                    decode.append(str);
                }
                str = decode;
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
