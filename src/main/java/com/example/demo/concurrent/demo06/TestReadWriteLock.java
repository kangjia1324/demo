package com.example.demo.concurrent.demo06;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 写锁（独占锁）：一次只能被一个线程占有
 * 读锁（共享锁）：多个线程可以同时占有
 * ReadWriteLock:读写锁。
 * 读 - 读：可以共存
 * 读 - 写：不能共存
 * 写 - 写：不能共存
 * @author kangJia
 * @date 2021/1/16 19:49
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        MyCache2 myCache = new MyCache2();

        // 写入
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp);
            }, String.valueOf(i)).start();
        }

        // 读取
        for (int i = 0; i < 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}

// 自定义缓存，加锁，读写安全
class MyCache2 {
    private volatile Map<String, Object> map = new HashMap<>();

    // 读写锁：更加细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    // 存，写的过程。只希望同时只有一个线程写
    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始写入：" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入完毕" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    // 取，读的过程。所有人都可以读
    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "开始读取：" + key);
            Object value = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取成功" + key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}

// 自定义缓存，未加锁，不安全
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();

    // 存，写的过程
    public void put(String key, Object value) {
        System.out.println(Thread.currentThread().getName() + "开始写入：" + key);
        map.put(key, value);
        System.out.println(Thread.currentThread().getName() + "写入完毕" + key);

    }

    // 取，读的过程
    public void get(String key) {
        System.out.println(Thread.currentThread().getName() + "开始读取：" + key);
        Object value = map.get(key);
        System.out.println(Thread.currentThread().getName() + "读取成功" + key);
    }
}
