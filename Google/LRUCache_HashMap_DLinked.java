class LRUCache extends LinkedHashMap<Integer, Integer>{

    private int capacity;
    private int size;
    private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
    private DLinkedNode head, tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node == null){
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;
            cache.put(key, newNode);
            addNode(newNode);
            ++size;
            if(size > capacity){
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
    
    class DLinkedNode{
        int value;
        int key;
        DLinkedNode next;
        DLinkedNode prev;
    }
    
    private void addNode(DLinkedNode node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(DLinkedNode node){
        DLinkedNode next = node.next;
        DLinkedNode prev = node.prev;
        
        prev.next = next;
        next.prev = prev;
    }
    
    private void moveToHead(DLinkedNode node){
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedNode popTail(){
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
