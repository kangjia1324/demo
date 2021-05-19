package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 8. 一个静态同步方法，一个普通同步方法，两个对象来操做，两个线程先发短信还是先打电话？  答案：打电话，4s后发短信
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test8 {
    public static void main(String[] args) {
        Phone8 phone = new Phone8();
        Phone8 phone2 = new Phone8();

        // A 线程
        new Thread(() -> {
            phone.sendSms();
        }, "A").start();

        // 休息 1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // B 线程
        new Thread(() -> {
            phone2.call();
        }, "B").start();
    }
}

class Phone8{
    // synchronized 锁的是对象是方法的调用者
    // static 静态方法 ，类一加载就有了！Class 模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    // 普通同步方法，锁的是调用者 pbone 对象
    public synchronized void call() {
        System.out.println("打电话");
    }
}
