package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 7. 一个静态同步方法，一个普通同步方法，一个对象来操做，两个线程先发短信还是先打电话？  答案：程序执行4s后发短信，再打电话
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test7 {
    public static void main(String[] args) {
        Phone7 phone = new Phone7();

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
            phone.call();
        }, "B").start();
    }
}

class Phone7{
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
