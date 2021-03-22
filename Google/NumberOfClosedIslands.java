class Solution {
    public int closedIsland(int[][] grid) {
        int row = grid.length, col = grid[0].length, totalClosedArea = 0;
        for(int r=0; r<row; r++){
            for(int c=0; c<col; c++){
                if(grid[r][c] == 0){
                    if(closedArea(grid, r, c)){
                        totalClosedArea++;
                    }
                }
            }
        }
        return totalClosedArea;
    }
    
    public boolean closedArea(int[][] grid, int r, int c){
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length){
            return false;           
        }
        if(grid[r][c] == 1){
            return true;
        }
        grid[r][c]=1;
        boolean p1 = closedArea(grid, r+1, c);
        boolean p2 = closedArea(grid, r-1, c);
        boolean p3 = closedArea(grid, r, c+1);
        boolean p4 = closedArea(grid, r, c-1);
        return p1&&p2&&p3&&p4;
    }
}

