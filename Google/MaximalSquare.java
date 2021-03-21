class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[][] dp = new int[rows+1][cols+1];
        int maximalSqr = 0;
        for(int r = 1; r <= rows; r++){
            for(int c = 1; c<= cols; c++){
                if(matrix[r-1][c-1] == '1'){
                    dp[r][c] = Math.min(Math.min(dp[r][c-1], dp[r-1][c]), dp[r-1][c-1]) + 1;
                    maximalSqr = Math.max(maximalSqr, dp[r][c]);
                }
            }
        }
        return maximalSqr * maximalSqr;
    }
}

//Time Complexity O(m*n) and Space Complexity O(m*n) => dp matrix
//Runtime: 4 ms, faster than 88.37% of Java online submissions for Maximal Square.
//Memory Usage: 42.4 MB, less than 50.21% of Java online submissions for Maximal Square.
