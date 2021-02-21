package ThreadUtils;
/*
    @author  zjc
    @create 2021-02-21-22:16  
*/

import java.util.concurrent.CountDownLatch;

// 原理    数量  1
//  等待计数器归零   然后再向下执行
//每次有线程调用   countDown() 数量-1  ,假设计数器归零 downLatch.await(); 就会被唤醒,继续执行
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //总数是 6
        CountDownLatch downLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread( () ->{
                System.out.println(Thread.currentThread().getName()+"Go out");
              //数量 -1
            },String.valueOf(i)).start();
        }
        downLatch.await(); //等待计数器归零,然后再向下执行
        downLatch.countDown();  //-1
        System.out.println("close door");

    }
}
