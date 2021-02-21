package ThreadUtils;/*
    @author  zjc
    @create 2021-02-21-23:53  
*/

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
 原理   获取和释放
 设置一个限度   然后获得   到达限度后  等待     释放后 唤醒等待的线程\
 多个共享资源互斥时    并发限流   控制最大的线程数
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量  停车位  //限流
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 6; i++) {
            new Thread(()  ->{
               // acquire() 获得
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
                //release  释放
            },String.valueOf(i)).start();
        }

    }
}
