package Sigle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/*
    @author  zjc
    @create 2021-02-25-21:47  
*/
// 懒汉式
/*
        1.  基本的可以通过 双重检测锁模式 加原子性操作 DCL懒汉式
        2.  反射可以破坏  可以判断实例不等于null  阻止反射创建
            2.1  反射创建两个对象  不用正常方法创建  前面的就不行了  这时候加一个标志位 如果不通过反编译找不到
        3. 如果拿到了标志位 可以反射创建后 再次将标志位修改  还是可以破坏


        Cannot reflectively create enum objects

 */
public class Lazy {

    private static boolean zhaomo = false;   //标志位  如果不通过反编译找不到
    private Lazy(){
        synchronized (Lazy.class){
            if (zhaomo==false){
                zhaomo = true;
            }else {
                throw new RuntimeException("不要试图使用反射破坏单例");
            }
//            if (lazy != null){
//                throw new RuntimeException("不要试图使用反射破坏单例");
//            }
        }
        System.out.println(Thread.currentThread().getName() +" ok " );
    }
    private volatile static Lazy lazy;
    // 双重检测锁模式 加原子性操作 DCL懒汉式
    public static Lazy getInstance(){
        // 加锁
        if (lazy==null){
            synchronized (Lazy.class){
                if (lazy==null){
                    lazy = new Lazy();   //不是原子性操作
                    /**
                     *  1. 分配内存空间
                     *  2. 执行构造方法初始化对象
                     *  3. 把这个对象指向这个空间
                     *
                     *  123
                     *  132  A 先占用空间 再放对象
                     *       B
                     */
                }
            }
        }
        return lazy;    //此时Lazy还没有构造
    }

    //反射 !
    public static void main(String[] args) throws Exception {
//        Lazy instance = Lazy.getInstance();
        Field zhaomo = Lazy.class.getDeclaredField("zhaomo");
        zhaomo.setAccessible(true);

        Constructor<Lazy> constructor = Lazy.class.getDeclaredConstructor(null);
        constructor.setAccessible(true);
        Lazy instance = constructor.newInstance();
        zhaomo.set(instance,false);
        Lazy newInstance2 = constructor.newInstance();
        System.out.println(instance);
        System.out.println(newInstance2);
    }

//    public static void main(String[] args) {
//        for (int i = 1; i < 10; i++) {
//            new Thread( () -> {
//                Lazy.getInstance();
//            }).start();
//        }
//    }

}
