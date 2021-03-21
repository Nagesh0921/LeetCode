class Solution {
    public int countSquares(int[][] matrix) {
        int rows = matrix.length, cols = rows>0? matrix[0].length : 0, ans = 0;
        int[][] dp = new int[rows+1][cols+1];
        for(int r = 1; r <= rows; r++){
            for(int c = 1; c <= cols; c++){
                if(matrix[r-1][c-1] == 1){
                    dp[r][c] = Math.min(Math.min(dp[r][c-1], dp[r-1][c]), dp[r-1][c-1]) + 1;
                    ans += dp[r][c];
                }
            }
        }
        return ans;
    }
}

//Time Complexity O(mn)
