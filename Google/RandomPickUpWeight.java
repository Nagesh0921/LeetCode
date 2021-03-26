class Solution {

    private int[] prefixSum;
    private int totalSum;
    
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        for(int i=0; i<w.length; i++){
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int i=0;
        for(; i<prefixSum.length; i++){
            if(target < prefixSum[i]){
                return i;
            }
        }
        return i-1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

//Time Complexity O(N)

//READ NOTES BEFORE!!!

//As it is sorted Array- we can use Binary Search

class Solution {

    private int[] prefixSum;
    private int totalSum;
    
    public Solution(int[] w) {
        this.prefixSum = new int[w.length];
        for(int i=0; i<w.length; i++){
            totalSum += w[i];
            prefixSum[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int left = 0, right = prefixSum.length-1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target > prefixSum[mid]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

//Time Complexity is O(logN)
