class Solution {
    List<List<Integer>> adjList = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1){
            return false;
        }
        
        //create graph
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList<>());
        }
        //add edge
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        dfs(0);
        
        return visited.size() == n;
    }
    
    private void dfs(int node){
        if(visited.contains(node)){
            return;
        }   
        visited.add(node);
        for(Integer neighbor : adjList.get(node)){
            dfs(neighbor);
        }
    }
}

//A Graph becomes Tree when no CYCLES are present.
