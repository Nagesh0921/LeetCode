class Solution{
    
  
    int Countpair(int a[], int n, int sum)
    {
        // Complete the function
        int left = 0, right = n-1, noOfPairs = 0;
        while(left < right){
            if(a[left] + a[right] == sum){
                left++;
                right--;
                noOfPairs++;
            } else if(a[left] + a[right] < sum){
                left++;
            } else {
                right--;
            }
        }
        return (noOfPairs == 0) ? -1 : noOfPairs;
    }
  
    
}

//Time Complexity O(N)
