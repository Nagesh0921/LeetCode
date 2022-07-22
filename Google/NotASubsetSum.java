class Solution {
    long findSmallest(long[] arr, int n) {
        // code here
        long result = 1;
        for(int i=0; i<n && arr[i]<=result; i++){
            result += arr[i];
        }
        return result;
    }
}

//Input:
//N = 3
//Arr[] = {1, 2, 3}
//Output: 7
//Explanation: 7 is the smallest positive number 
//for which any subset is not present with sum 7.
