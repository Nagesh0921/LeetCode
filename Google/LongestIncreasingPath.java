class Solution {
    int[] rowDir = {1,0,-1,0};
    int[] colDir = {0,1,0,-1};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, ans = 0;
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                ans = Math.max(ans, dfsWalk(matrix, r, c));
            }
        }
        return ans;
    }
    
    public int dfsWalk(int[][] matrix, int r, int c){
        int ans = 0;
        for(int i=0; i<4 ; i++){
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];
            if(newRow >= 0 && newRow <= matrix.length-1 && newCol >= 0 && newCol <= matrix[0].length-1
              && matrix[newRow][newCol] > matrix[r][c]){
                ans = Math.max(ans, dfsWalk(matrix, newRow, newCol));
            }
        }
        return ++ans;
    }
}

//Time Complexity O(4*(2^m+n)) -> 4 is for directions which is constant and can be ignored. and 2 raise to row and col which is recursive stack.
//As we are visiting same path multiple times we can cache it.

class Solution {
    int[] rowDir = {1,0,-1,0};
    int[] colDir = {0,1,0,-1};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length, ans = 0;
        int[][] cache = new int[rows][cols];
        for(int r = 0; r<rows; r++){
            for(int c = 0; c<cols; c++){
                ans = Math.max(ans, dfsWalk(matrix, r, c, cache));
            }
        }
        return ans;
    }
    
    public int dfsWalk(int[][] matrix, int r, int c, int[][] cache){
        if(cache[r][c] != 0){
            return cache[r][c];
        }
        for(int i=0; i<4 ; i++){
            int newRow = r + rowDir[i];
            int newCol = c + colDir[i];
            if(newRow >= 0 && newRow <= matrix.length-1 && newCol >= 0 && newCol <= matrix[0].length-1
              && matrix[newRow][newCol] > matrix[r][c]){
                cache[r][c] = Math.max(cache[r][c], dfsWalk(matrix, newRow, newCol, cache));
            }
        }
        return ++cache[r][c];
    }
}

//Time Complexity is O(4:Row*Col)
