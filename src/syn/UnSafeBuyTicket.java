package syn;
/*
    @author  zjc
    @create 2021-02-20-21:19
     
*/
//不安全的买票  有负数
public  class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"苦逼的我").start();
        new Thread(station,"牛逼的你").start();
        new Thread(station,"黄牛党").start();

    }
}
class  BuyTicket implements Runnable{
    private int ticketNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized  同步方法  实现锁  锁的是this
    private  void buy() throws InterruptedException {
        //判断是否有票
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到第"+ticketNums--+"张票");
    }
}