class Solution
{
	// Function to find the peak element
	// arr[]: input array
	// n: size of array a[]
	public int peakElement(int[] arr,int n)
    {
       //add code here.
       int left = 0, right = arr.length-1;
       while(left < right){
           int mid = (left + right)/2;
           if(arr[mid] > arr[mid+1]){
               right = mid;
           } else {
               left = mid+1;
           }
       }
       return left;
    }
}

//Time Complexity O(log N)
