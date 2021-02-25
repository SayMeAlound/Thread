package ForkJoin;/*
    @author  zjc
    @create 2021-02-24-20:32  
*/

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算的任务
 *  3000  6000(ForkJoin)   9000(Stream  并行流)
 *  如何使用ForkJoin
 *      1. ForkJoinPool  通过它来执行
 *      2. 计算任务  forkJoinPool.execute(ForkJoinTask task)
 *      3. 计算类要继承RecursiveTask
 *
 *
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private  Long start;
    private  Long end;
    private  Long temp =1000L;

    public ForkJoinDemo(Long start, Long end) {
        this.start = start;  //1
        this.end = end;     //10000000000
    }


    public static void main(String[] args) {



    }
    //计算方法
    @Override
    protected Long compute() {
        if((end -start)> temp){
            //分支合并计算
            Long sum = 0L;
            for (Long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        }else {   //forkjoin
            Long middle = (start + end) / 2; //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, middle);
            task1.fork();    //拆分任务 ,把任务压入线程队列
            ForkJoinDemo task2 = new ForkJoinDemo(middle, end);
            task2.fork();   //拆分任务 ,把任务压入线程队列
            long sum = task1.join() + task2.join();
            return sum;
        }
    }
}
