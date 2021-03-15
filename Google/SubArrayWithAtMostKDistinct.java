class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int len = s.length();
        if(len < k){
            return len;
        }
        HashMap<Character, Integer> uniqueVal = new HashMap<>();
        int start=0, end=0, maxVal = Integer.MIN_VALUE;
        while(end < len){
            uniqueVal.put(s.charAt(end), end++);
            if(uniqueVal.size() > k){
                int index = Collections.min(uniqueVal.values());
                uniqueVal.remove(s.charAt(index));
                start = index+1;
            }
            maxVal = Math.max(maxVal, end-start);
        }
        return maxVal;
    }
}

//Time Complexity O(N) and Space Complexity is O(k)
