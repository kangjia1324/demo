package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 6. 使用两个对象来操作这两个静态同步方法，两个线程先发短信还是先打电话？  答案：程序执行4s后发短信，再打电话
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test6 {
    public static void main(String[] args) {
        // 两个对象的 Class 对象实际只有一份
        Phone6 phone = new Phone6();
        Phone6 phone2 = new Phone6();

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

// Pbone5 唯一的一个 Class 对象
class Phone6{
    // synchronized 锁的是对象是方法的调用者
    // static 静态方法
    // 类一加载就有了！Class 模板
    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call() {
        System.out.println("打电话");
    }


}
