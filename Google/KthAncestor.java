class TreeAncestor {
    int[][] preComputedTree;
    public TreeAncestor(int n, int[] parent) {
        int col = (int)(Math.log(n)/Math.log(2))+1;
        preComputedTree = new int[n][col];
        for(int i=0; i<n; i++){
            preComputedTree[i][0] = parent[i];
        }
        
        for(int c=1; c<col; c++){
            for(int r=0; r<n; r++){
                if(preComputedTree[r][c-1] == -1){
                    preComputedTree[r][c] = -1;
                } else {
                    preComputedTree[r][c] = preComputedTree[preComputedTree[r][c-1]][c-1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        if(node == -1){
            return -1;
        }
        int height = (int)(Math.log(k)/Math.log(2));
        if((1<<height) == k){
            return preComputedTree[node][height];
        }
        return getKthAncestor(preComputedTree[node][height], k-(1<<height));
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */

//Time Complexity O(nlogN)
