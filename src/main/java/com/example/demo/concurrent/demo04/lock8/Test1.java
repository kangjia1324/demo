package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 1.标准情况下，两个线程先发短信还是先打电话？   1、发短信  2、打电话
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        // A 线程
        new Thread(phone::sendSms, "A").start();

        // 休息 1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // B 线程
        new Thread(phone::call, "B").start();
    }
}
class Phone{
    public synchronized void sendSms() { System.out.println("发短信"); }
    public synchronized void call() { System.out.println("打电话"); }
}
