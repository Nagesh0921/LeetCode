class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if(matrix.length == 0){
            return ans;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] isVisited = new boolean[row][col];
        int[] rowDir = {0, 1, 0, -1};
        int[] colDir = {1, 0, -1, 0};
        int direction = 0, r=0 , c=0;
        for(int i=0; i<row*col; i++){
            ans.add(matrix[r][c]);
            isVisited[r][c] = true;
            int cr = r + rowDir[direction];
            int cc = c + colDir[direction];
            if(0 <= cr && cr < row && 0 <= cc && cc < col && !isVisited[cr][cc]){
                r = cr;
                c = cc;
            } else {
                direction = (direction + 1)%4;
                r += rowDir[direction];
                c += colDir[direction];
            }
        }
        return ans;
    }
}

//Time Complexity O(n) and SPace Complexity is O(n)
