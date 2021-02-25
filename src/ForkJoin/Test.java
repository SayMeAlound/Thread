package ForkJoin;/*
    @author  zjc
    @create 2021-02-24-20:53  
*/

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test2();
        test1();
        test3();
    }
    // 第一层
    public static void test1(){
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for (Long i = 0L; i < 10_0000_0000L; i++) {
            sum += i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum = "+sum +" 时间: "+(end-start));   //7419

    }
    //第二层  forkJoin
    public static void test2() throws ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);//提交任务
        Long sum = submit.get();

        Long end = System.currentTimeMillis();
        System.out.println("sum = "+sum +" 时间: "+(end-start));   //7818

    }
    public static void test3(){
        Long start = System.currentTimeMillis();
        // Stream 并行流
        long sum = LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0, Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum = "+sum +" 时间: "+(end-start));   //584
    }
}
