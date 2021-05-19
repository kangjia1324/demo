package com.example.demo.concurrent.demo04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kangJia
 * @date 2021/1/16 14:01
 */
public class SaleTicket02 {
    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket2 ticket = new Ticket2();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();

    }

}

/**
 * lock 三部曲：
 * 1. new ReentrantLock();
 * 2. 加锁 lock.lock();
 * 3. finally 里释放锁 lock.unlock();
 */
class Ticket2 {
    // 属性、方法
    private int number = 30;

    Lock lock = new ReentrantLock();

    // 买票的方式
    public void sale() {
        lock.lock();  // 加锁，要在 try 代码块之外
        try {
            // 业务代码
            if (number >0) {
                System.out.println(
                        Thread.currentThread().getName() + "卖出了 " + number-- + " 票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();  // 释放锁
        }
    }
}
