class Solution {
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i=0; i<stones.length; i++){
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(0);
        for(int i=0; i<stones.length; i++){
            for(int values : map.get(stones[i])){
                for(int k = values-1; k<=values+1; k++){
                    if(k > 0 && map.containsKey(stones[i]+k)){
                        map.get(stones[i]+k).add(k);
                    }
                }
            }
        }
        return map.get(stones[stones.length-1]).size() > 0;
    }
}
//Time Complexity is O(N^2) and Space Complexity is O(N^2) worst case scenario where hashmap is growing to n^2
