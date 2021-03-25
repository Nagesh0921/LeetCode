class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int distance = 0;
        int start = 0;
        while(seats[distance] == 0){
            distance++;
        }
        for(int i=distance+1; i<len; i++){
            if(seats[i] == 0){
                start++;
            } else {
                distance = Math.max(distance, (start + 1)/2);
                start = 0;
            }
        }
        return Math.max(distance, start);
    }
}

//Time Complexity is O(N) and Space Complexity is O(1)
//Idea is distance beween two people is (last empty point + 1 / 2)
