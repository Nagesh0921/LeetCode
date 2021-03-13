class Solution {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        return nums[len-k];
    }
}
//Time Complexity O(nlogn) and Space Complexity O(1)
//Runtime: 3 ms, faster than 68.04% of Java online submissions for Kth Largest Element in an Array.
//Memory Usage: 42 MB, less than 6.64% of Java online submissions for Kth Largest Element in an Array.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for(Integer n : nums){
            q.add(n);
            if(q.size() > k){
                q.poll();
            }
        }
        return q.poll();
    }
}

//Runtime: 6 ms, faster than 31.55% of Java online submissions for Kth Largest Element in an Array.
//Memory Usage: 42.3 MB, less than 5.45% of Java online submissions for Kth Largest Element in an Array.

