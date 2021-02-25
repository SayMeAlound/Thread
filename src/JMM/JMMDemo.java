package JMM;/*
    @author  zjc
    @create 2021-02-25-18:26  
*/

import java.util.concurrent.TimeUnit;

public class JMMDemo {
    private volatile static int num = 0;
    public static void main(String[] args) {
        new Thread( () -> {
           while (num==0){
//               System.out.println("工作内存和内存中不一致");
           }
        }).start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        num = 1;
        System.out.println(num);
    }
}
