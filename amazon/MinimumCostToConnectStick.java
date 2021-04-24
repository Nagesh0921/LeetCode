class Solution {
    public int connectSticks(int[] sticks) {
        //This problem with Brute Force can hit on Time Complexity
        //As initially we need to sort the sticks
        //After every addition we again need to sort to get properly aligned values
        //If we can think of any inbuilt data structure that supports sorting 
        //as in Heap : Min Heap to be specific, after every addition when we add it to
        //queue, heap will automatically align Min Element at root.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int totalCost = 0;
        for(int a : sticks){
            pq.add(a);
        }
        
        while(pq.size() > 1){
            int stick1 = pq.remove();
            int stick2 = pq.remove();
            
            totalCost += stick1 + stick2;
            pq.add(stick1 + stick2);
        }
        
        return totalCost;
    }
}

//Time Complexity O(n)
