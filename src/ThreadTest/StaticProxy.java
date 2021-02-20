package ThreadTest;/*

    @author  zjc
    @create 2021-02-19-12:32
     
*/

public class StaticProxy {
    public static void main(String[] args) {
        You you = new You();  //你要结婚

        new Thread( () -> System.out.println("我爱你")).start();

        new WeedingCompany(you).HappyMarry();

    }
}

interface Marry{

    void HappyMarry();
}

//真实角色   你去结婚
class You implements Marry{
    @Override
    public void HappyMarry() {
        System.out.println("赵先生要结婚了");
    }
}

//代理角色   帮你结婚
class WeedingCompany implements Marry {
    //代理谁  -->  真实对象
    private Marry target;

    public WeedingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();  //真实对象
        after();
    }
    private void before(){
        System.out.println("结婚之前,布置现场");
    }
    private void after() {
        System.out.println("结婚之后,收尾款");
    }
}
