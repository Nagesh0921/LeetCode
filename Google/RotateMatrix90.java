class Solution {
    public void rotate(int[][] matrix) {
        //Consider a Matrix cells in the form of mathematical formulas
        //like matrix[0][0] = [m - (m/2) - 1][col value]
        //matrix[0][2] = [m - 1 - row value][m - (m/2) - 1]
        int len = matrix.length;
        for(int i = 0; i < (len+1)/2; i++){
            for(int j = 0; j < len/2; j++){
                int temp = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - j - 1];
                matrix[len - 1 - i][len - j - 1] = matrix[j][len - 1 - i];
                matrix[j][len - 1- i] = matrix[i][j]; 
                matrix[i][j] = temp;
            }
        }
    }
}

//Time Complexity is O(M)
