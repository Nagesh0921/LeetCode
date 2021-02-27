// Time Complexity - O(n^2)
class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] median = new double[nums.length-k+1];
        for(int i=0; i<=nums.length-k;i++){
            double[] temp = new double[k];            
            for(int j=0; j<k; j++){
                temp[j] = nums[i+j];
            }
            Arrays.sort(temp);
            median[i] = temp[k/2];
        }
        return median;
    }
}
