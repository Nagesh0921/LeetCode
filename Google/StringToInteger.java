class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0){
            return 0;
        }
        int result = 0;
        int i=0;
        int sign = 1;
        
        //Corner case
        //Corner case
        int j=0;
        if(s.length() > 1) {
        	while(j < s.length() && (s.charAt(j+1) == '+' && s.charAt(j) == '-') || s.charAt(j+1) == '-' && s.charAt(j) == '+' || (s.charAt(j+1) == '+' && s.charAt(j) == '+') || (s.charAt(j+1) == '-' && s.charAt(j) == '-')){
                return 0;
            }
        }
        
        while(i < s.length() && s.charAt(i) == ' '){
            i++;
        }
        
        while(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-') ){
            sign = (s.charAt(i++) == '-') ? -1 : 1;
        }
        
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            if(result > Integer.MAX_VALUE/10 || result == Integer.MAX_VALUE/10 && s.charAt(i) - '0' > Integer.MAX_VALUE % 10){
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (s.charAt(i++) - '0');
        }
        return result * sign;
    }
}

// Time Complexity O(N) and Space Complexity O(1)
// This code is failing at 1080 test case out of 1082 :)
