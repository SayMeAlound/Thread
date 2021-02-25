package JMM;/*
    @author  zjc
    @create 2021-02-25-18:36  
*/

import java.util.concurrent.atomic.AtomicInteger;

public class JMMDemo02 {
    //volatile 不保证原子性
    //原子类的int
    private volatile static AtomicInteger num = new AtomicInteger();
    public  static void add(){    //可以加 synchronize 和 lock  保证
        //num ++;               不是一个原子性操作
        num.getAndIncrement();    // AtomicInteger.getAndIncrement()  AtomicInteger+1 方法  底层CAS
    }

    //理论上num 为 2万
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            new Thread( () -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() >2){   //main  Gc  默认执行
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" num "+num);
    }
}
