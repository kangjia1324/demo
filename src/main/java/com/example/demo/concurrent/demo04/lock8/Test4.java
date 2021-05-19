package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 4. 两个phone4 对象，两个同步方法，两个线程先发短信还是先打电话？  答案：程序执行打电话，4s后发短信
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test4 {
    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        Phone4 phone2 = new Phone4();

        // A 线程
        new Thread(phone::sendSms, "A").start();

        // 休息 1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // B 线程
        new Thread(phone2::call, "B").start();
    }
}

class Phone4{
    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call() {
        System.out.println("打电话");
    }

    // 普通方法不受锁的影响
    public void hello() {
        System.out.println("hello");
    }
}
