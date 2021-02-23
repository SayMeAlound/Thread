package ThreadPool;/*
    @author  zjc
    @create 2021-02-23-23:39  
*/

import java.util.concurrent.*;
//Executors  工具类(类似 Collections Arrays)  线程池   三大方法

public class Demo2 {
    public static void main(String[] args) {
        //必须手动创建线程池

        /*
        * 最大线程如何定义 :    (调优)
        *                   CPU密集型    几核就定义为几   CPU效率最高
        *                   IO密集型     判断的你的程序中十分耗IO的线程   一般设置其两倍
        *                               程序中有  15 个大型任务   IO 十分占用资源  至少留15 个处理  设置30个
        *
        */

        System.out.println(Runtime.getRuntime().availableProcessors());  //获取CPU核数
        ExecutorService threadpool =new ThreadPoolExecutor(
                2,5,3, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3) ,Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        try {
            //最大承载  最大线程数  + 等待队列
            for (int i = 1; i <= 8; i++) {
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
