class Solution {
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, 0, 0);
    }
    
    public int minPathSum(int[][] grid, int i, int j){
        if(i == grid.length || j == grid[0].length){
            return Integer.MAX_VALUE;
        }
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        return grid[i][j] + Math.min(minPathSum(grid, i+1, j), minPathSum(grid, i, j+1));
    }
}

//Time Complexity O(2^m*n) and Space Complexity O(N+M)

//Dynamic Programming
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] result = new int[row][col];
        for(int i = row-1; i >= 0; i--){
            for(int j = col-1; j >=0; j--){
                if(i == row-1 && j != col-1){
                    result[i][j] = grid[i][j] + result[i][j+1];
                } else if(i != row-1 && j == col-1) {
                    result[i][j] = grid[i][j] + result[i+1][j];
                } else if(j != col-1 && i != row-1) {
                    result[i][j] = grid[i][j] + Math.min(result[i+1][j], result[i][j+1]);
                } else {
                    result[i][j] = grid[i][j];
                }
            }
        }
        return result[0][0];
    }
}

//Time Complexity O(NM) and Space Complexity is O(NM)

