package Sigle;/*
    @author  zjc
    @create 2021-02-25-22:11  
*/


// 静态内部类
public class InerClass {
    private InerClass(){

    }
    private static InerClass getInstance(){
        return Inner.INNERCLASS;
    }

    public static class  Inner{
        private static final InerClass INNERCLASS = new InerClass();
    }


}
