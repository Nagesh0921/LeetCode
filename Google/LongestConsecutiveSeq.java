class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        Arrays.sort(nums);
        int longestStreak = 1;
        int currentStreak = 1;
        for(int i=1; i<len; i++){
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1] + 1){
                    currentStreak++;
                } else {
                    longestStreak = Math.max(longestStreak, currentStreak);
                    currentStreak = 1;
                }
            }
        }
        return Math.max(longestStreak, currentStreak);
    }
}

//Time Complexity is O(nLogN) and Space Complexity O(N)
//Runtime: 3 ms, faster than 82.69% of Java online submissions for Longest Consecutive Sequence.
//Memory Usage: 40.5 MB, less than 17.86% of Java online submissions for Longest Consecutive Sequence.


class Solution {
    public int longestConsecutive(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        HashSet<Integer> values = new HashSet<>();
        for(int n : nums){
            values.add(n);
        }
        
        int longestStreak = 0;
        
        for(int num : nums){
            if(!values.contains(num-1)){
                int curNum = num;
                int currentStreak = 1;
                while(values.contains(curNum+1)){
                    curNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
//Time Complexity is O(N) and Space Complexity is O(N)
