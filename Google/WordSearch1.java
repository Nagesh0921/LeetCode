class Solution {
//     public boolean exist(char[][] board, String word) {
//         int rows = board.length, cols = board[0].length;
//         boolean[][] isUsed = new boolean[rows][cols];
//         for(int r = 0; r < rows; r++){
//             for(int c = 0; c < cols; c++){
//                 return exist(board, word, isUsed, 0, r, c);
//             }
//         }
//         return false;
//     }
    
//     public boolean exist(char[][] grid, String word, boolean[][] isUsed, int index, int r, int c){
//         if(index == word.length()){
//             return true;
//         }
//         if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || isUsed[r][c]){
//             return false;
//         }
//         if(grid[r][c] == word.charAt(index)){
//             isUsed[r][c] = true;
//             if(exist(grid, word, isUsed, index+1, r, c+1) ||
//                exist(grid, word, isUsed, index+1, r, c-1) ||
//                exist(grid, word, isUsed, index+1, r+1, c) ||
//                exist(grid, word, isUsed, index+1, r-1, c)){
//                 return true;
//             }
//             isUsed[r][c] = false;
//         }
//         return false;
//     }
    public boolean exist(char[][] board, String word) {
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if (helper(board, x ,y, word, 0, used)) return true;
            }
        }
        return false;
    }
    
    public boolean helper(char[][] board, int x, int y, String word, int index, boolean[][] used) {
        if (index == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || used[x][y]) return false;
         
        if (board[x][y] == word.charAt(index)) {
            used[x][y] = true;
            if(helper(board, x, y + 1, word, index + 1, used) ||
                helper(board, x, y - 1, word, index + 1, used) ||
                helper(board, x + 1, y, word, index + 1, used) ||
                helper(board, x - 1, y, word, index + 1, used)) return true;
            used[x][y] = false;
        }
        return false;
    }
}

//Time Complexity O(R*C)
