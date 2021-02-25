package Lock;/*
    @author  zjc
    @create 2021-02-26-00:34  
*/

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    // int 默认零
    //Thread  null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();
    //加锁
    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " ==> mylock");
        //自旋锁
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }

    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " ==> Unlock");
        atomicReference.compareAndSet(thread,null);
    }
}
