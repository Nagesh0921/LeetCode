class Solution {
    public int countComponents(int n, int[][] edges) {
        //Similar to Object Array : Every Index is List of connected components
        List<Integer>[] adjList = new ArrayList[n];
        HashSet<Integer> visited = new HashSet<>();
        int[] visit = new int[n];
        int counter = 0;
        for(int i=0; i<n; i++){
            adjList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<edges.length; i++){
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }
        
        for(int i=0; i<n; i++){
            // if(visit[i] == 0){
            //     counter++;
            //     dfsTraversal(adjList, visit, i);
            // }
            if(!visited.contains(i)){
                counter++;
                dfsTraversal(adjList, visited, i);
            }
        }
        
        return counter;
    }
    
//     private void dfsTraversal(List<Integer>[] adjList, int[] visit, int start){
//         visit[start] = 1;
        
//         for(int i=0; i<adjList[start].size(); i++){
//             if(visit[adjList[start].get(i)] == 0){
//                 dfsTraversal(adjList, visit, adjList[start].get(i));
//             }
//         }
//     }
    
    private void dfsTraversal(List<Integer>[] adjList, HashSet<Integer> visited, int start){
        visited.add(start);
        
        for(int i=0; i<adjList[start].size(); i++){
            if(!visited.contains(adjList[start].get(i))){
                dfsTraversal(adjList, visited, adjList[start].get(i));
            }
        }
    }
}

//Time Complexity is O(V+E)
