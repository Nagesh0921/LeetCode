class Solution {
    public String minWindow(String S, String T) {
        if(S == null || T == null){
            return null;
        }
        int len = S.length(), j=0; String ans="";
        for(int i=0; i<len; i++){
            if(T.charAt(j) == S.charAt(i)){
                j++;
            }
            if(j >= T.length()){
                int end = i+1;
                j--;
                while(j >= 0){
                    if(S.charAt(i) == T.charAt(j)){
                        j--;    
                    }
                    i--;
                }
                i++;
                String temp = S.substring(i, end);
                if(ans.length() == 0 || temp.length() < ans.length()){
                    ans = temp;
                }
                j=0;
            }
        }
        return ans;
    }
}

//Time Complexity O(N) and Space Complexity O(1)
