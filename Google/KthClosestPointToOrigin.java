class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        int len = points.length;
        int[] distance = new int[len];
        for(int i=0; i<len; i++){
            distance[i] = euclideanDist(points[i]);
        }
        Arrays.sort(distance);
        int distAtK = distance[k-1];
        int t = 0;
        for(int i=0; i<len; i++){
            if(euclideanDist(points[i]) <= distAtK){
                result[t++] = points[i];
            }
        }
        return result;
    }
    
    public int euclideanDist(int[] point){
        return point[0]*point[0] + point[1]*point[1];
    }
}

//Time Complexity O(nLog n) Space Complexity O(N)
//This is real life exmaple of finding nearest shops to your location!!!
