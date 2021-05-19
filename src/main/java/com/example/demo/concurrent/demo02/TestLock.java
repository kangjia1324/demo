package com.example.demo.concurrent.demo02;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kangJia
 * @date 2021/1/15 15:20
 */
public class TestLock{
    public static void main(String[] args) {
        final TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}
class TestLock2 implements Runnable {
    // 票
    private int ticketNums = 6;
    private boolean flag = true;  // 外部停止方式

    // 定义 lock 锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock(); // 加锁
                if (ticketNums > 0) {
                    Thread.sleep(1000);
                    System.out.println(ticketNums--);
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // 释放锁
                lock.unlock();
            }


        }
    }
}
