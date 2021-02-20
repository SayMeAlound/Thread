package JUC;/*

    @author  zjc
    @create 2021-02-21-01:24
     
*/

import java.util.concurrent.locks.ReentrantLock;

//测试Lock 锁
public class TestLock {
    public static void main(String[] args) {
        TestLock2 lock2 = new TestLock2();
        new Thread(lock2).start();
        new Thread(lock2).start();
        new Thread(lock2).start();
    }

}
class TestLock2 implements Runnable{
    int ticketNum= 10;

    //定义Lock锁
    private  final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){
            try {
                lock.lock();  //加锁
                if (ticketNum>0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(ticketNum--);
                }else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
