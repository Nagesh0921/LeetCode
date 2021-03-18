class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for(int[] ar : result){
            Arrays.fill(ar, 1);
        }
        for(int c = 1; c < m; c++){
            for(int r = 1; r < n; r++){
                result[c][r] = result[c-1][r] + result[c][r-1];
            }
        }
        return result[m-1][n-1];
    }
}

//Time Complexity O(N*M) as we are traveling each of m and each of n position in grid
//Space Complexity O(N*M)
