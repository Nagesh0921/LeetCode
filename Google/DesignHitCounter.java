class HitCounter {

    Queue<Integer> hits;
    
    /** Initialize your data structure here. */
    public HitCounter() {
        this.hits = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.hits.add(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!this.hits.isEmpty()){
            int intervals = timestamp - this.hits.peek();
            if(intervals >= 300){
                this.hits.remove();
            } else {
                break;
            }
        }
        return this.hits.size();
    }
}

/**
 * <<Read NOTES before this!!!>>
 * 
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */


