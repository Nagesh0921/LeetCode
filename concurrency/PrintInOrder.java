class Foo {

    private Semaphore[] semaphore;
     
    public Foo() {
        int noOfThreads = 3;
        semaphore = new Semaphore[noOfThreads];
        
        try{
            for(int i=0; i<3; i++){
                semaphore[i] = new Semaphore(1, true);

                semaphore[i].acquire();
            }

            semaphore[0].release();
        } catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public void first(Runnable printFirst) throws InterruptedException {
        semaphore[0].acquire();
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        
        semaphore[1].release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        semaphore[1].acquire();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        
        semaphore[2].release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        semaphore[2].acquire();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        
        semaphore[0].release();
    }
}
