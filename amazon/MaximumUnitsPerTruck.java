class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1]);
        int unitsPerTruck = 0;
        for(int i=0; i<boxTypes.length; i++){
            int boxCount = Math.min(truckSize, boxTypes[i][0]);
            unitsPerTruck += boxTypes[i][1] * boxCount;
            truckSize -= boxCount;
            if(truckSize == 0){
                break;
            }
        }
        return unitsPerTruck;
    }
}

//Time Complexity O(NlogN) and Space Complexity O(nLogn)

//This can be done with Max Heap concept using Priority Queue.
