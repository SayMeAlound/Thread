package callable;/*
    @author  zjc
    @create 2021-02-21-21:54  
*/

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        //new Thread(new Runnable()).start();
        //new Thread(new FutureTask<V>()).start();
        //new Thread(new FutureTask<V>( Callable)).start();

        new Thread().start();  //怎么启动Callable
        MyThread thread = new MyThread();

        FutureTask futureTask = new FutureTask<>(thread);  //适配类
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();  //结果会被缓存
        try {
            Integer o = (Integer) futureTask.get();   //获取Callable的返回结果  get 方法可能会产生阻塞  放到最后一行 或者使用异步通信
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}


class MyThread implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");  //两条线程 会打印几个call
        return 1024;
    }
}