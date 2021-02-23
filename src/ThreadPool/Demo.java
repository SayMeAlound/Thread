package ThreadPool;/*
    @author  zjc
    @create 2021-02-23-23:39  
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//Executors  工具类(类似 Collections Arrays)  线程池   三大方法

public class Demo {
    public static void main(String[] args) {
//        ExecutorService threadpool = Executors.newSingleThreadExecutor();//单个线程
//        ExecutorService threadpool = Executors.newFixedThreadPool(5);  //固定的线程池大小
        ExecutorService threadpool =Executors.newCachedThreadPool();  //可伸缩的  遇强则强 遇弱则弱

        try {
            for (int i = 0; i < 100; i++) {
                //使用了线程池之后  使用线程池创建线程
                threadpool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //线程池要关闭
            threadpool.shutdown();
        }
    }
}
