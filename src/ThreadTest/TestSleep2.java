package ThreadTest;/*

    @author  zjc
    @create 2021-02-19-15:42
     
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep2 {
    public static void main(String[] args) throws InterruptedException {
//        tenDown();   //倒计时
        //打印当前系统时间
        Date startTime = new Date(System.currentTimeMillis());  //获取系统当前时间
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());  //更新当前时间
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static  void tenDown() throws InterruptedException {
        int num= 10 ;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0){
                break;
            }
        }
    }
}
