class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Brute Force
        //Add every Character and match String with words in word Dictionary
        //As we are seeing a pattern here of recurrsion we can think of memoization.
        //Lets think of Decision making based on the word list and word matches in the string
        //we cache that result in some array.
        //As in all DP we will create a standard boolean array
        if(s == null || wordDict.size() < 1){
            return false;
        }
        int length = s.length();
        boolean[] dp = new boolean[length+1];
        Arrays.fill(dp, false);
        dp[length] = true;
        for(int i=length-1; i>=0; i--){
            for(String str : wordDict){
                if((i+str.length() <= length) && str.equals(s.substring(i, i+str.length()))){
                    dp[i] = dp[i+str.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];
    }
}

//Time Complexity O(n*m) and Space Complexity is O(N)
