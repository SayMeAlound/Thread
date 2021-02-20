package ThreadTest;/*

    @author  zjc
    @create 2021-02-19-15:31
     
*/
//模拟网络延时  : 放大问题的发生性
public class TestSleep implements Runnable{
    private int tickets = 10;

    @Override
    public void run() {
        while (true){
            if (tickets<=0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"-->拿到了第"+tickets--+"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();

        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"小红").start();
        new Thread(testSleep,"小绿").start();
    }
}
