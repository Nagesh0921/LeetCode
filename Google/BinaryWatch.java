class Solution {
    int[] map = {1,2,4,8,1,2,4,8,16,32};
    ArrayList<String> result = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        backTrack(0,0,0,num);
        return result;
    }
    
    public void backTrack(int hourIndex, int minIndex, int mapIndex, int left){
        if(mapIndex == 10 && left != 0){
            return;
        } else if(left == 0) {
            result.add(transform(hourIndex,minIndex));
            return;
        } else {
            if(mapIndex < 4 && hourIndex+map[mapIndex] < 12){
                backTrack(hourIndex+map[mapIndex], minIndex, mapIndex+1, left-1);
            } else if(mapIndex >= 4 && minIndex+map[mapIndex] < 60) {
                backTrack(hourIndex, minIndex+map[mapIndex], mapIndex+1, left-1);
            }
            backTrack(hourIndex, minIndex, mapIndex+1, left);
        }  
    }
    
    public String transform(int hour, int min){
        StringBuilder sb = new StringBuilder();
        sb.append(hour).append(":");
        sb = (min < 10) ? sb.append("0").append(min) : sb.append(min);
        return sb.toString();
    }
}
