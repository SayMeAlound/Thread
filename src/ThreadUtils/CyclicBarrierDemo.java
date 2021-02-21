package ThreadUtils;/*
    @author  zjc
    @create 2021-02-21-22:45  
*/

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        /*
        *   集齐七颗龙珠召唤神龙
        */
        //召唤龙珠线程

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("召唤神龙成功");
        });


        for (int i = 1; i <= 7; i++) {
            final int temp = i;
            // Lambda 能操作到变量i 吗 ?
            new Thread( () -> {
                System.out.println(Thread.currentThread().getName()+"收集"+temp+"个龙珠");
                try {
                    cyclicBarrier.await();  //等待
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();

        }
    }

}
