class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longestSeq = Integer.MIN_VALUE;
        if(s.length() == 0){
            return 0;
        }
        if(s.length() == 1){
            return 1;
        }
        HashSet<Character> uniqueSet = new HashSet<>();
        int i=0,j=0;
        while(i<s.length() && j<s.length()){
            char c = s.charAt(i);
            if(!uniqueSet.contains(s.charAt(i))){
                uniqueSet.add(c);
                i++;
                longestSeq = Math.max(longestSeq, (i-j));
            } else {
                uniqueSet.remove(s.charAt(j));
                j++;
            }
        }
        return longestSeq;
    }
}

// Time Complexity O(N) and Space Complexity O(N)
