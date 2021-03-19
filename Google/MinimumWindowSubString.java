class Solution {
    public String minWindow(String s, String t) {
        if(s == null || t == null){
            return null;
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            int count = map.getOrDefault(t.charAt(i),0);
            map.put(t.charAt(i), count+1);
        }
        
        int left = 0, right = 0, frequency = 0;
        int[] ans = {-1,0,0};
        HashMap<Character, Integer> windowsMap = new HashMap<>();
        
        while(right < s.length()){
            char c = s.charAt(right);
            int count = windowsMap.getOrDefault(c, 0);
            windowsMap.put(c, count+1);
            
            if(map.containsKey(c) && windowsMap.get(c).intValue() == map.get(c).intValue()){
                frequency++;
            }
            
            while(left <= right && frequency == map.size()){
                c = s.charAt(left);
                if(ans[0] == -1 || right - left +1 < ans[0]){
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                windowsMap.put(c, windowsMap.get(c)-1);
            
                if(map.containsKey(c) && windowsMap.get(c).intValue() < map.get(c).intValue()){
                    frequency--;
                }

                left++;
            }
            right++;
        }
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2]+1);
    }
}

// Time Complexity O(S+T)
