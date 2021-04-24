class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = {{0,1},{1,0},{0,-1,},{-1,0}};
        int x = 0, y = 0, index = 0;
        for(char ch : instructions.toCharArray()){
            if(ch == 'R'){
                index = (index + 1) % 4;
            } else if (ch == 'L'){
                index = (index + 3) % 4;
            } else {
                x += directions[index][0];
                y += directions[index][1];
            }
        }
        
        return (x == 0 && y == 0) || (index != 0);
    }
}

//Time Complexity is O(n) and Space Copmplexity is O(1)
