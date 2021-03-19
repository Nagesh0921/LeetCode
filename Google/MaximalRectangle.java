class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int rlen = matrix.length;
        int clen = matrix[0].length;
        int maxA = 0;
        int[] result = new int[clen+1];
        for(int r = 0; r < rlen; r++){
            for(int c = 0; c < clen; c++){
                if(matrix[r][c] == '1'){
                    result[c] = result[c] + 1;
                } else {
                    result[c] = 0;
                }
            }
            maxA = Math.max(maxA, maxArea(result));
        }
        return maxA;
        
    }
    
    public int maxArea(int[] temp){
        Stack<Integer> st = new Stack();
        st.push(-1);
        int maxArea = 0, len = temp.length;
        for(int i=0; i<len; i++){
            while(st.peek() != -1 && temp[st.peek()] >= temp[i]){
                int curHt = temp[st.pop()];
                int curWd = i - st.peek() - 1;
                maxArea = Math.max(maxArea, curHt*curWd);
            }
            st.push(i);
        }
        while(st.peek() != -1){
            int curHt = temp[st.pop()];
            int curWd = len - st.peek() -1;
            maxArea = Math.max(maxArea, curHt*curWd);
        }
        return maxArea;
    }
}

//Time Complexity O(Row*Col) Space Complexity O(Col)
