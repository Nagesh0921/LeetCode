class Solution {
    public int minCostII(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        
        int rowHouse = costs.length;
        int colColor = costs[0].length;
        
        //Reason to start with House/row = 1; we need previous house color
        for(int house = 1; house < rowHouse; house++){
            for(int color = 0; color < colColor; color++){
                int minCost = Integer.MAX_VALUE;
                for(int prevColor = 0; prevColor < colColor; prevColor++){
                    //Adj houses should not have same color
                    if(color == prevColor){
                        continue;
                    }
                    minCost = Math.min(minCost, costs[house-1][prevColor]);
                }
                //Memoization
                costs[house][color] += minCost;
            }
        }
        
        int minCost = Integer.MAX_VALUE;
        for(int c : costs[rowHouse-1]){
            minCost = Math.min(minCost, c);
        }
        
        return minCost;
    }
}
//Time Complexity: for every House row-> n, for every Color Column-> k^2 => O(n*k^2)


//Optimized
