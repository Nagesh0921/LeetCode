public class LinkedListSamples1 {
    LinkedNode1 head = null;
    class LinkedNode1{
        LinkedNode1 next;
        int value;

        public LinkedNode1(int value){
            this.value = value;
        }
    }   
    
    public void push(int value){
        if(head == null){
           head = new LinkedNode1(value); 
           return;
        }
        LinkedNode1 newNode = new LinkedNode1(value);
        newNode.next = head;
        head = newNode;
    }

    public LinkedNode1 display(){
        return head;
    }

    public void pop(int value){
        if(head == null){
            return;
        }
        if(head.next != null){
            head = head.next;
        } else {
            head = null;
        }
    }

    public static void main(String[] args) {
        LinkedListSamples1 sample = new LinkedListSamples1();
        sample.push(10);
        sample.push(20);
        sample.push(30);
        LinkedNode1 current = sample.display();
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
        System.out.println("-------");
        sample.pop(30);
        System.out.println("-------");
        current = sample.display();
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }
}
