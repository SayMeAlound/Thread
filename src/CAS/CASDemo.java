package CAS;/*
    @author  zjc
    @create 2021-02-25-22:44  
*/

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/*
        CAS  比较当前工作内存中的值和内存中的值,如果这个值是期望的,那么则执行操作,如果不是一直循环!  do while
        缺点:
            1.自旋锁  循环会耗时
            2.一次性只能保证一个共享变量的原子性
            3.ABA问题
 */
public class CASDemo {
    //CAS  compareAndSet  比较并交换
    public static void main(String[] args) {
        AtomicInteger atomicInteger =new  AtomicInteger(2021);

        //对于我们写的SQL来说   : 乐观锁!
        // 期望  更新
        // public final boolean compareAndSet(int expect, int update) {
        // 如果期望值达到了  就更新 否则就不更新  CAS 是CPU的并发原语
        // ============捣乱线程 ===========
        System.out.println(atomicInteger.compareAndSet(2021, 2022));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2022, 2021));
        System.out.println(atomicInteger.get());
        // ============期望线程 ===========
        System.out.println(atomicInteger.compareAndSet(2021, 6666));
        System.out.println(atomicInteger.get());

    }
}
