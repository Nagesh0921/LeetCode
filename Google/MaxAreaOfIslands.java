class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, maxArea = 0;
        boolean[][] isVisited = new boolean[row][col];
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                maxArea = Math.max(maxArea, area(grid,r,c,isVisited));
            }
        }
        return maxArea;
    }
    
    public int area(int[][] grid, int r, int c, boolean[][] isVisited){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || isVisited[r][c]){
            return 0;
        }
        isVisited[r][c] = true;
        return 1 + area(grid, r+1, c, isVisited) + area(grid, r, c+1, isVisited) +
            area(grid, r-1, c, isVisited) + area(grid, r, c-1, isVisited);
    }
}

//Time Complexity of DFS in Matrix is O(R*C) and Space Complexity O(R*C)
