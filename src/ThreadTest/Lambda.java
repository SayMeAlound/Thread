package ThreadTest;
/*
    @author  zjc
    @create 2021-02-19-13:57
*/

/*
推到Lambda表达式
 */
public class Lambda {
    //3.静态内部类
    static class Like2 implements ILike{
        @Override
        public void Lambda() {
            System.out.println("I like Lambda2");
        }
    }
    public static void main(String[] args) {
        ILike like = new Like();
        like.Lambda();

        like = new Like2();
        like.Lambda();

        //4. 局部内部类
        class Like3 implements ILike{
            @Override
            public void Lambda() {
                System.out.println("I like Lambda3");
            }
        }
        like = new Like3();
        like.Lambda();


        //5. 匿名内部类  没有类的名称,必须借助接口或者父类
        like = new ILike() {
            @Override
            public void Lambda() {
                System.out.println("I like Lambda4");
            }
        };
        like.Lambda();

        //用Lambda简化
        like = () -> System.out.println("I like Lambda5");
        like.Lambda();

    }
    
}

//1. 定义一个函数式接口    (只包含一个方法  线程的Runnable 就是例子)
interface ILike{
    void Lambda();
}

//2.  实现类
class Like implements ILike{
    @Override
    public void Lambda() {
        System.out.println("I like Lambda");
    }
}
