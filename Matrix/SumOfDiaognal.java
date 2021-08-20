class Solution {
    public int diagonalSum(int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        int totalSum = 0;
        if(rows == 1 && cols == 1){
            return mat[0][0];
        }
        // for(int row=0; row<rows; row++){
        //     for(int col=0; col<cols; col++){
        //         if(row == col){
        //             totalSum += mat[row][col];
        //         }
        //         if((row+col) == cols-1){
        //             totalSum+= mat[row][col];
        //         }
        //     }
        // }
        for(int row = 0; row < rows; row++){
            totalSum += mat[row][row] + mat[row][rows-row-1];
        }
        if((rows&1) != 0){
            totalSum -= mat[rows/2][cols/2];
        }
        return totalSum;
    }
}

//Time Complexity of initial solution: O(Rows * Cols)
//Optimized : O(Row) 
//Understanding of Matrix:
/**
To get any column based on Rows: col = total length (row length) - row - 1
*/
