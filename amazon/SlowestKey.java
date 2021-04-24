class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int[] duration = new int[26];
        int len = keysPressed.length();
        duration[keysPressed.charAt(0) - 'a'] = releaseTimes[0];
        for(int i=1; i<len; i++){
            char ch = keysPressed.charAt(i);
            if(releaseTimes[i] - releaseTimes[i-1] >= duration[ch - 'a']){
               duration[ch - 'a'] = releaseTimes[i] - releaseTimes[i-1]; 
            }
        }
        char result = ' ';
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            if(duration[i] >= max){
                max = duration[i];
                result = (char)(i + 'a');
            }
        }
        return result;
    }
}
