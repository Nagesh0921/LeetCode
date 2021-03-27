class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length(), j = 0;
        for(int i=len-1; i>=0; i--){
            if(s.charAt(j) == s.charAt(i)){
                j++;
            }
        }
        if(j == len){
            return s;
        }
        
        StringBuilder sb = new StringBuilder(s.substring(j, len));
        sb.reverse();
        return sb.toString() + shortestPalindrome(s.substring(0, j)) + s.substring(j);
    }
}

//Time Complexity is O(N^2) due to reverse string and recurrsion

//Optimized Solution with KMP -> Knuth Morris Pratt

