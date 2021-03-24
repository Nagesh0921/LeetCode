class LFUCache {
    
    class LFUObj{
        int key;
        int value;
        int frequency;
        int timestamp;
        
        LFUObj(int key, int value, int frequency, int timestamp){
            this.key = key;
            this.value = value;
            this.frequency = frequency;
            this.timestamp = timestamp;
        }
    }
    
    int capacity;
    HashMap<Integer, LFUObj> cache;
    PriorityQueue<LFUObj> queue;
    private static int incrementalTS;
    
    public LFUCache(int capacity) {
        cache = new HashMap<Integer, LFUObj>();
        queue = new PriorityQueue<>(new Comparator<LFUObj>(){
            public int compare(LFUObj l1, LFUObj l2){
                return (l1.frequency != l2.frequency) ? (l1.frequency - l2.frequency) : (l1.timestamp - l2.timestamp);
            }
        });
        this.incrementalTS = 0;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(capacity == 0){
            return -1;
        }
        if(cache.containsKey(key)){
            LFUObj lf = cache.get(key);
            queue.remove(lf);
            cache.remove(lf);
            update(key, lf.value);
            return cache.get(key).value;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            //update the frquency of cache item
            update(key, value);
        } else {
            if(!queue.isEmpty() && queue.size() >= capacity){
                cache.remove(queue.poll().key);
            }
            LFUObj lf = new LFUObj(key, value, 1, incrementalTS++);
            cache.put(key, lf);
            queue.add(lf);
        }
    }
    
    public void update(int key, int value){
        LFUObj lf = cache.get(key);
        queue.remove(lf);
        cache.remove(lf.key);
        LFUObj newObj = new LFUObj(lf.key, value, lf.frequency+1, incrementalTS++);
        queue.offer(newObj);
        cache.put(key, newObj);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
