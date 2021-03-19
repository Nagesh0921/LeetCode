class Solution {
    public boolean canConvert(String str1, String str2) {
        if(str1 == null || str2 == null){
            return false;
        }
        if(str1.equals(str2)){
            return true;
        }
        HashMap<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int len = str1.length();
        for(int i=0; i<len; i++){
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if(map.containsKey(c1) && map.get(c1) != c2){
                return false;
            }
            map.put(c1,c2);
            set.add(c2);
        }
        if(set.size() == 26 && map.size() == 26){
            return false;
        }
        return true;
    }
}

//Time Comlexity O(N) and Space Complexity O(N)
// Try to solve with Graph!!!
