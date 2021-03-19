class NumMatrix {
    
    private int[][] data;
    int pRow = 0, pCol =0;
    public NumMatrix(int[][] matrix) {
        data = matrix;
        pRow = data.length;
        pCol = data[0].length;
    }
    
    public void update(int row, int col, int val) {
        if((row<=pRow && row >= 0) && (col <= pCol && col >=0)){
            data[row][col] = val;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int r = row1; r<= row2; r++){
            for(int c = col1; c<=col2; c++){
                sum += data[r][c];    
            }
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */

//Time Complexity is O(Row*Col) and Space Complexity O(Row*Col)
