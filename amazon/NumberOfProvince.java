class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashSet<Integer> visited = new HashSet<>();
        int count = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!visited.contains(i)){
                dfsTraversal(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }
    
    private void dfsTraversal(int[][] isConnected, HashSet<Integer> visited, int start){
        for(int i=0; i<isConnected.length; i++){
            if(isConnected[start][i] == 1 && !visited.contains(i)){
                visited.add(i);
                dfsTraversal(isConnected, visited, i);
            }
        }
    }
}

//Time Complexity O(V^2) as this is Adj Matrix
