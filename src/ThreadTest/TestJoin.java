package ThreadTest;/*

    @author  zjc
    @create 2021-02-20-19:06
     
*/

//测试join方法
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程VIP来了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();
        //主线程
        for (int i = 0; i < 500; i++) {
            if (i==200){
                thread.join();  //插队
            }
            System.out.println("main"+i);
        }
    }
}
