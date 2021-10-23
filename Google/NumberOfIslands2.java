class Solution {
    char[][] grid;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        grid = new char[m][n];
        List<Integer> result = new ArrayList<Integer>();
        
        for(char[] row : grid){
            Arrays.fill(row, '0');
        }
        for(int[] pos : positions){
            grid[pos[0]][pos[1]] = '1';
            result.add(numberOfIslands(grid));    
        }
        return result;
    }
    
    private int numberOfIslands(char[][] grid){
        if(grid == null || grid.length == 0){
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    numberOfIslands++;
                    dfs(grid, visited, r, c);
                }
            }
        }
        return numberOfIslands;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] || grid[row][col] == '0'){
            return;
        }
        
        visited[row][col] = true;
        dfs(grid, visited, row+1, col);
        dfs(grid, visited, row-1, col);
        dfs(grid, visited, row, col+1);
        dfs(grid, visited, row, col-1);
    }
}

//Time Complexity - O(L * m * n)
//Union Find
