package syn;/*

    @author  zjc
    @create 2021-02-20-21:45
     
*/

import java.util.ArrayList;
import java.util.List;

//线程不安全的集合
public class UnSafeList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }
        Thread.sleep(3000);
        System.out.println(list.size());
    }

}
