class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> q = new ArrayDeque<>();
        int rows = grid.length, cols = grid[0].length;
        int freshOranges = 0, minutesElapsed = -1;
        int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                if(grid[r][c] == 2){
                    q.offer(new Pair(r,c));
                }
                if(grid[r][c] == 1){
                    freshOranges++;
                }
            }
        }
        q.offer(new Pair(-1,-1));
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey();
            int col = p.getValue();
            if(row == -1){
                minutesElapsed++;
                if(!q.isEmpty()){
                    q.offer(new Pair(-1,-1));
                }
            } else {
                for(int[] d: direction){
                    int newRow = row + d[0];
                    int newCol = col + d[1];
                    if(newRow >=0 && newRow < rows && newCol >= 0 && newCol < cols){
                        if(grid[newRow][newCol] == 1){
                            grid[newRow][newCol] = 2;
                            freshOranges--;
                            q.offer(new Pair(newRow, newCol));
                        }
                    }
                }
            }
        }
        
        return freshOranges == 0 ? minutesElapsed : -1;
    }
}
