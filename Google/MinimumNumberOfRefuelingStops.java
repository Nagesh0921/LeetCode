class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //Greedy Approach
        //Let's Discuss in startFuel how far we can go.
        int noOfStation = stations.length;
        long[] farthestDist = new long[noOfStation+1];
        farthestDist[0] = startFuel;
        
        //Let's check one by by Fuel Station how to reach
        //We need to check how max we have covered.
        for(int i=0; i<noOfStation; ++i){
            for(int j=i; j>=0; --j){
                if(farthestDist[j] >= stations[i][0]){
                    farthestDist[j+1] = Math.max(farthestDist[j+1], ((long)stations[i][1]+farthestDist[j]));
                }
            }
        }
        for(int i=0; i<farthestDist.length; i++){
            if(farthestDist[i] >= target){
                return i;
            }
        }
        return -1;
    }
}
//Time Complexity is O(N^2) and Space is O(N)
//As most of the problems of min and max can be handled with Heaps in better time complexity in avg case scenario, here is the implementation.
//Idea is to keep the capacity which is nothing but stations[i][1] in Queue.
//Consider a scenario where u have fuel in car and you are going to decide if we need to fuel it.
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> distance = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0, currentPos = startFuel, pos = 0;
        while(currentPos < target){
            while(pos < stations.length && stations[pos][0] <= currentPos){
                distance.offer(stations[pos][1]);
                pos++;
            }
            if(distance.isEmpty()){
               return -1; 
            }
            currentPos += distance.poll();
            result++;
        }
        return result;
    }
}

//Time Complexity O(NLogN) Space Complexity O(N)
//Runtime: 2 ms, faster than 99.44% of Java online submissions for Minimum Number of Refueling Stops.
//Memory Usage: 39.3 MB, less than 54.03% of Java online submissions for Minimum Number of Refueling Stops.
