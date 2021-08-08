class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> generate(int numRows) {
        //For top row in triangle we will always have 1
        result.add(new ArrayList<>());
        result.get(0).add(1);
        
        //Iterate over each row from top
        for(int i=1; i<numRows; i++){
            //For each row in triangle
            List<Integer> rows = new ArrayList<>();
            //Prev Row details
            List<Integer> prevRows = result.get(i-1);
            
            //Every rows first column would always 1
            rows.add(1);
            
            for(int j=1; j<i; j++){
                rows.add(prevRows.get(j-1) + prevRows.get(j));    
            }
            
            //Last column of every row would be 1
            rows.add(1);
            
            result.add(rows);
        }
        
        return result;
    }
}

//Time Complexity O(numRows ^ 2)
