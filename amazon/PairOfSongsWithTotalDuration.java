class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length, count = 0;
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                if((time[i] + time[j])%60 == 0){
                    count++;
                }
            }
        }
        return count;
    }
}

//Time Complexity O(n^2) and Space Complexity is O(1)

//This can be solved with PrefixSum and HashMap
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int len = time.length, count = 0;
        // for(int i=0; i<len; i++){
        //     for(int j=i+1; j<len; j++){
        //         if((time[i] + time[j])%60 == 0){
        //             count++;
        //         }
        //     }
        // }
        // return count;
        HashMap<Integer, Integer> values = new HashMap();
        for(int i=0; i<len; i++){
            if(time[i]%60 == 0 && values.containsKey(0)){
                count += values.get(0);
            } else if(values.containsKey(60 - time[i]%60)){
                count += values.get(60 - time[i]%60);
            }
            
            values.put(time[i]%60, values.getOrDefault(time[i]%60, 0)+1);
        }
        return count;
    }
}

//Time Complexity is O(n)
