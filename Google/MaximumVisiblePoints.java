class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        ArrayList<Double> angles = new ArrayList<>();
        int count = 0;
        for(List<Integer> p : points){
            int dx = p.get(0) - location.get(0);
            int dy = p.get(1) - location.get(1);
            if(dx == 0 && dy == 0){
                count++;
                continue;
            }
            angles.add(Math.atan2(dx,dy)*(180/Math.PI));
        }
        int result = count;
        Collections.sort(angles);
        ArrayList<Double> temp = new ArrayList<>(angles);
        for(double d : angles){
            temp.add(d+360);
        }
        for(int i=0, j=0; i<temp.size(); i++){
            while((temp.get(i)-temp.get(j)) > angle){
                j++;
            }
            result = Math.max(result, count+i-j+1);
        }
        return result;
    }
}

//Time Complexity O(N + NLogN)=> O(nLogn) Space Complexity O(N LogN)
// This problem looks confusing due to "D" mentioned in problem statement. The "d" is nothing but from you location get all angles correspnding to 
// given points in an array.
// Another thing to focus here is "Sort", if we sort all the points based on the angles then we just need to slide over them to understand which points we can cover
// in "Angle" mentioned => like sliding over that windown.
// Hence "Sliding Window".
