package ThreadTest;/*

    @author  zjc
    @create 2021-02-20-19:13
     
*/
//测试线程状态
public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////////");
        });

        //观察状态
        Thread.State state = thread.getState();

        System.out.println(state);   //New

        //观察启动后
        thread.start();  //启动线程
        System.out.println(thread.getState());  //Run

        while (state != Thread.State.TERMINATED){   //只要线程不终止 就一直输出状态
            Thread.sleep(1000);
            state = thread.getState();
            System.out.println(state);
        }
    }

}
