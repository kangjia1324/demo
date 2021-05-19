package com.example.demo.concurrent.demo04.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 八锁，就是关于锁的 8 个问题
 * 3. 增加一个普通方法 hello()，两个线程先发短信还是先 hello？  答案：程序先执行 hello 方法，4s后发短信
 * @author kangJia
 * @date 2021/1/16 15:26
 */
public class Test3 {
    public static void main(String[] args) {
        Phone3 phone = new Phone3();

        // A 线程
        new Thread(phone::sendSms, "A").start();

        // 休息 1s
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // B 线程
        new Thread(phone::hello, "B").start();
    }
}

class Phone3{
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

    public void hello() {
        System.out.println("hello");
    }
}
