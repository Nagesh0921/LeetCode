class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<>();
        if(areSidesSame(p1, p2) || areSidesSame(p1, p3) || areSidesSame(p1, p4) || areSidesSame(p2, p3) || areSidesSame(p2, p4) || areSidesSame(p3, p4)){
            return false;
        }
        set.add(distance(p1,p2));
        set.add(distance(p1,p3));
        set.add(distance(p1,p4));
        set.add(distance(p2,p3));
        set.add(distance(p2,p4));
        set.add(distance(p3,p4));
        
        return set.size() == 2;
    }
    
    public int distance(int[] pt1, int[] pt2){
        return (pt1[0]-pt2[0])*(pt1[0]-pt2[0]) + (pt1[1]-pt2[1])*(pt1[1]-pt2[1]);
    }
    
    public boolean areSidesSame(int[] pt1, int[] pt2){
        return (pt1[0] == pt2[0]) && (pt1[1] == pt2[1]);
    }
}
