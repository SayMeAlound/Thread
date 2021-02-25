package Sigle;/*
    @author  zjc
    @create 2021-02-25-22:28  
*/


import java.lang.reflect.Constructor;

// 枚举是一个什么?  本身也是一个类
public enum EnumSingle {
    INSTANCE;
    public EnumSingle getInstance(){
        return INSTANCE;
    }

}
class Test{
    public static void main(String[] args) throws Exception {
        EnumSingle instance1 = EnumSingle.INSTANCE;
        System.out.println(instance1);
        Constructor<EnumSingle> constructor = EnumSingle.class.getDeclaredConstructor(String.class,int.class);   //枚举式有参构造
        constructor.setAccessible(true);
        EnumSingle instance2 = constructor.newInstance();

        //java.lang.NoSuchMethodException
        System.out.println(instance1);
        System.out.println(instance2);
    }
}
