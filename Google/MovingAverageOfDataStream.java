class MovingAverage {

    private int size, windowSum = 0, count = 0;
    private Deque<Integer> q;
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.size = size;
        q = new ArrayDeque<Integer>();
    }
    
    public double next(int val) {
        count++;
        q.add(val);
        int last = count > this.size ? q.poll() : 0;
        windowSum = windowSum - last + val;
        return windowSum * 1.0 / Math.min(size, count);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

//Time Complexity is O(1) as we are using Deque and Space Complexity is O(N)
