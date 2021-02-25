package Lock;/*
    @author  zjc
    @create 2021-02-26-00:44  
*/

import java.util.concurrent.TimeUnit;

//jps -l   查看死锁进程号   通过进程号找到死锁问题
//jstack 进程号  然后查看信息
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lcokA";
        String lockB = "lcokB";

        new Thread(new Mythread(lockA, lockB), "T1").start();
        new Thread(new Mythread(lockB, lockA), "T2").start();
    }
}
class  Mythread implements Runnable{
    private String lockA;
    private String lockB;

    public Mythread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName() + "lock: " +lockA + " ==>get"+ lockB);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName() + "lock: " +lockB+ " ==>get"+ lockA);
            }
        }
    }
}
