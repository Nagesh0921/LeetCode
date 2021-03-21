class Solution {
    public int longestMountain(int[] arr) {
        int len = arr.length;
        int ans = 0, start = 0, end = 0;
        while(start < len){
            end = start;
            if(end + 1 < len && arr[end] < arr[end+1]){
                while(end + 1 < len && arr[end] < arr[end+1]){
                    end++;
                }
                if(end + 1 < len && arr[end] > arr[end+1]){
                    while(end + 1 < len && arr[end] > arr[end+1]){
                        end++;
                    }
                    ans = Math.max(ans, end-start+1);
                }
            }
            start = Math.max(end, start + 1);
        }
        return ans;
    }
}

//Time Complexity is O(N) and Space Complexity O(1)
