package ThreadTest;/*

    @author  zjc
    @create 2021-02-19-14:19
     
*/

public class TestLambda {
    public static void main(String[] args) {
//        ILove love = new Love();
//        love.love(2);

        ILove love = (int a) -> System.out.println("I love You-->"+a);
        love.love(2);
    }
}
interface ILove{
    void love(int a);
}
class Love implements ILove{
    @Override
    public void love(int a) {
        System.out.println("I love You-->"+a);
    }
}
