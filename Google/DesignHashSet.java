class MyHashSet {

    private Bucket[] buckets;
    private int keyRange;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        keyRange = 769;
        buckets = new Bucket[this.keyRange];
        for(int i=0; i<this.keyRange; i++){
            buckets[i] = new Bucket();
        }
    }
    
    protected int _hash(int key){
        return (key % this.keyRange);
    }
    
    public void add(int key) {
        int bucketIndex = _hash(key);
        this.buckets[bucketIndex].insert(key);
    }
    
    public void remove(int key) {
        int bucketIndex = _hash(key);
        this.buckets[bucketIndex].delete(key);
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = _hash(key);
        return this.buckets[bucketIndex].contains(key);
    }
}

class Bucket{
    LinkedList<Integer> container;
    
    public Bucket(){
        this.container = new LinkedList<>();
    }
    
    public void insert(Integer key){
        if(this.container.indexOf(key) == -1){
            this.container.addFirst(key);
        }
    }
    
    public void delete(Integer key){
        this.container.remove(key);
    }
    
    public boolean contains(Integer key){
        if(this.container.indexOf(key) == -1){
            return false;
        }
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
