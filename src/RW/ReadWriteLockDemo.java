package RW;/*
    @author  zjc
    @create 2021-02-22-00:03  
*/

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        MyCacheLock myCacheLock = new MyCacheLock();

//        //写入
//        for (int i = 1; i < 5; i++) {
//            final  int tmp = i;
//            new Thread(() -> {
//                myCache.put(tmp+"",tmp+"");
//            },String.valueOf(i)).start();
//        }
//        //读取
//        for (int i = 1; i < 5; i++) {
//            final  int tmp = i;
//            new Thread(() -> {
//                myCache.get(tmp+"");
//            },String.valueOf(i)).start();
//        }



        //写入
        for (int i = 1; i < 5; i++) {
            final  int tmp = i;
            new Thread(() -> {
                myCacheLock.put(tmp+"",tmp+"");
            },String.valueOf(i)).start();
        }
        //读取
        for (int i = 1; i < 5; i++) {
            final  int tmp = i;
            new Thread(() -> {
                myCacheLock.get(tmp+"");
            },String.valueOf(i)).start();
        }
    }
}

//加锁的
class MyCacheLock{
    private volatile Map<String,Object> map = new HashMap<>();
    //读写锁  更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//    private Lock lock = new ReentrantLock();

    //存  写  写入的时候只希望同时只有一个线程往里面写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"写入ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }

    }
    //取  读  所有人都可以读取
    public void get(String key){
        readWriteLock.readLock().lock();


        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            Object vlaue = map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取ok");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }

    }
}
/*
自定义缓存
*/
class MyCache{
    private volatile Map<String,Object> map = new HashMap<>();
    //存  写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入ok");
    }
    //取  读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object vlaue = map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取ok");
    }
}