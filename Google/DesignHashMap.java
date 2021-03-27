class MyHashMap {

    private Bucket[] buckets;
    private int keyRange;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.keyRange = 2068;
        buckets = new Bucket[this.keyRange];
        for(int i=0; i<this.keyRange; i++){
            buckets[i] = new Bucket();
        }
    }
    
    public int _hash(int key){
        return (key % this.keyRange);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketIndex = _hash(key);
        buckets[bucketIndex].update(key, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIndex = _hash(key);
        return buckets[bucketIndex].get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIndex = _hash(key);
        buckets[bucketIndex].remove(key);
    }
}

class Pair<U,V>{
    public U key;
    public V value;
    
    public Pair(U key, V value){
        this.key = key;
        this.value = value;
    }
}

class Bucket{
    private LinkedList<Pair<Integer, Integer>> containers;
    
    public Bucket(){
        this.containers = new LinkedList<>();
    }
    
    public void update(Integer key, Integer value){
        if(this.containers.isEmpty()){
            this.containers.add(new Pair<Integer, Integer>(key, value));
        }
        for(Pair<Integer, Integer> p : this.containers){
            if(p.key.equals(key)){
                p.value = value;
            } else {
                this.containers.add(new Pair<Integer, Integer>(key, value));
            }
        }
    }
    
    public void remove(Integer key){
        for(Pair<Integer, Integer> p : this.containers){
            if(p.key.equals(key)){
                this.containers.remove(p);
                break;
            }
        }
    }
    
    public Integer get(Integer key){
        for(Pair<Integer, Integer> p : this.containers){
            if(p.key.equals(key)){
                return p.value;
            }
        }
        return -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
