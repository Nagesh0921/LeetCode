class MaxStack {
    
    TreeMap<Integer, List<Node>> map;
    DoubleLinkedList dll;
    
    /** initialize your data structure here. */
    public MaxStack() {
        map = new TreeMap<>();
        dll = new DoubleLinkedList();
    }
    
    public void push(int x) {
        Node node = dll.add(x);
        if(!map.containsKey(x)){
            map.put(x, new ArrayList<Node>());
        }
        map.get(x).add(node);
    }
    
    public int pop() {
        int val = dll.pop();
        List<Node> list = map.get(val);
        list.remove(list.size()-1);
        if(list.isEmpty()){
            map.remove(val);
        }
        return val;
    }
    
    public int top() {
        return dll.peek();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size()-1);
        dll.unlink(node);
        if(list.isEmpty()){
            map.remove(max);
        }
        return max;
    }
}

class Node{
    int val;
    Node prev, next;
    
    public Node(int val){
        this.val = val;
    }
}

class DoubleLinkedList{
    Node head, tail;
    
    public DoubleLinkedList(){
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }
    
    public Node add(int val){
        Node temp = new Node(val);
        temp.next = tail;
        temp.prev = tail.prev;
        tail.prev.next = temp;
        tail.prev = temp;
        return temp;
    }
    
    public int pop(){
        return unlink(tail.prev).val;
    }
    
    public int peek(){
        return tail.prev.val;
    }
    
    public Node unlink(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
