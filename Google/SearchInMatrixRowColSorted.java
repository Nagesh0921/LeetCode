class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int diagonalCut = Math.min(matrix.length, matrix[0].length);
        for(int i=0; i<diagonalCut; i++){
            boolean verticalSlice = binarySearch(matrix, target, i, true);
            boolean horizontalSlice = binarySearch(matrix, target, i, false);
            return verticalSlice || horizontalSlice;
        }
        return false;
    }
    
    private boolean binarySearch(int[][] matrix, int target, int start, boolean isVertical){
        int low = start, high = isVertical ? matrix[0].length-1 : matrix.length-1;
        
        while(high >= low){
            int pivot = (low + high)/2;
            if(isVertical){
                if(target < matrix[low][pivot]){
                    high = pivot - 1 ;
                } else if (target > matrix[low][pivot]){
                    low = pivot + 1;
                } else {
                    return true;
                }
            } else {
                if(target < matrix[pivot][low]){
                    high = pivot - 1;
                } else if (target > matrix[pivot][low]){
                    low = pivot + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}

//T.C : O(log(n!))

//Optimized
class Solution 
{ 
    //Function to search a given number in row-column sorted matrix.
    // 3 30 38 36 43 60 40 51 69
    //row = index / n; col = index % n
    //we can use binary search and then search either vertical or horizontal
    // remember that we need to find diagonal first to minimize the search entries
    //Else we can use awesome technique
    // if matrix[row][col] < target row--
    // else matrix[row][col] > target col++
    // start pointer/row at bottom left
	static boolean search(int matrix[][], int n, int m, int x) 
	{  
	    // code here 
	    if(matrix == null || matrix.length == 0){
	        return false;
	    }
	    int row = matrix.length-1, col = 0;
	    while(row >= 0 && col < matrix[0].length){
	        if(x < matrix[row][col]){
	            row--;
	        } else if (x > matrix[row][col]){
	            col++;
	        } else {
	            return true;
	        }
	    }
	    return false;
	} 
} 
//T.C : O(n+m)
