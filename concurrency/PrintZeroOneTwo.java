class ZeroEvenOdd {
    private int n;
    private Semaphore zero, odd, even;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        odd = new Semaphore(0);
        even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=0; i<n; i++){
            zero.acquire();
            printNumber.accept(0);
            
            odd.release();
            even.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++){
            even.acquire();
            if((i&1) == 0){
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1; i<=n; i++){
            odd.acquire();;
            if((i&1) != 0){
                printNumber.accept(i);
                zero.release();
            }
        }
    }
}
