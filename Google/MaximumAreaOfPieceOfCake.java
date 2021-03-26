class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int maxH = 0, maxV = 0;
        int lenH = horizontalCuts.length, lenV = verticalCuts.length;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        for(int i=0; i<lenH; i++){
            maxH = Math.max(maxH, (i == 0 ? horizontalCuts[i] : 
                (horizontalCuts[i]-horizontalCuts[i-1])));
        }
        maxH = Math.max(maxH, h - horizontalCuts[lenH - 1]);
        
        for(int i=0; i<lenV; i++){
            maxV = Math.max(maxV, (i == 0 ? verticalCuts[i] :
                (verticalCuts[i] - verticalCuts[i-1])));
        }
        maxV = Math.max(maxV, w - verticalCuts[lenV - 1]);
        
        return (int) (maxH % (1e9 + 7) * maxV % (1e9 + 7));
    }
}

//This is similar to Prison Break Problem
//Instead of direct values there it is co-ordinates.
//Time Complexity is O(nLogN) due to sorting and Space Complexity is O(NLogN)
