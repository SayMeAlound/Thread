package CAS;/*
    @author  zjc
    @create 2021-02-25-22:44  
*/

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
        CAS  比较当前工作内存中的值和内存中的值,如果这个值是期望的,那么则执行操作,如果不是一直循环!  do while
        缺点:
            1.自旋锁  循环会耗时
            2.一次性只能保证一个共享变量的原子性
            3.ABA问题
        解决ABA问题   AtomicStampedReference  思想 乐观锁
 */
public class CASDemo {
    //CAS  compareAndSet  比较并交换

    // AtomicStampedReference Integer 注意Integer 包装类的值范围  -128  -127  注意对象引用问题
    //正常业务操作 这里面比较的都是一个个对象
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(1, 1);
    public static void main(String[] args) {
//        AtomicInteger atomicInteger =new  AtomicInteger(2021);


        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();   //获得版本号
            System.out.println("A1=> "+stamp);
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            // Version +1
            System.out.println(atomicStampedReference.compareAndSet(
                    1, 2, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A2=> "+atomicStampedReference.getStamp()+"更改为2");


            System.out.println(atomicStampedReference.compareAndSet(
                    2, 1, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1));
            System.out.println("A3=> "+atomicStampedReference.getStamp()+"更改为1");

        },"A").start();


        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();   //获得版本号
            System.out.println("B1=> "+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(atomicStampedReference.compareAndSet(1, 120, stamp, stamp + 1));
            System.out.println("B2=> "+atomicStampedReference.getStamp()+"更改为6");
        },"B").start();






//        //对于我们写的SQL来说   : 乐观锁!
//        // 期望  更新
//        // public final boolean compareAndSet(int expect, int update) {
//        // 如果期望值达到了  就更新 否则就不更新  CAS 是CPU的并发原语
//        // ============捣乱线程 ===========
//        System.out.println(atomicInteger.compareAndSet(2021, 2022));
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.compareAndSet(2022, 2021));
//        System.out.println(atomicInteger.get());
//        // ============期望线程 ===========
//        System.out.println(atomicInteger.compareAndSet(2021, 6666));
//        System.out.println(atomicInteger.get());

    }
}
