package Lock;/*
    @author  zjc
    @create 2021-02-26-00:37  
*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();

        // 底层使用的自旋锁
        SpinLockDemo lock = new SpinLockDemo();

        new Thread(() -> {
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"T1").start();
        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock.mylock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                lock.myUnLock();
            }
        },"T2").start();
    }
}
