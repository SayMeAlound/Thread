package Future;
   /*
    @author  zjc
    @create 2021-02-24-22:45  
*/

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步调用   CompletableFuture
 * //异步执行
 * //成功回调
 * // 失败回调
 */
public class Demo01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调  runAsync
//        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(Thread.currentThread().getName()+"runAsync => Void ");
//        });
//        System.out.println("111111111111111111111");
//        completableFuture.get();      //阻塞获取执行结果



        // 有返回值的异步回调
        //  Ajax  成功和失败的回调
        // 失败返回错误信息
        CompletableFuture<Integer> completableFuture =CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName()+"supplyAsync => Integer ");
            int i = 10 /0 ;
            return 1024;
        });
        System.out.println(completableFuture.whenComplete((t,u) -> {
            System.out.println("t=>" +t +"  u=> "+u);    //t=>1024  u=> null  t正常返回结果   u  错误信息
        }).exceptionally((e) ->{
            System.out.println(e.getMessage());
            return 233;
        }).get());


    }
}
