package com.example.demo.concurrent.demo05;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：计数器
 * 情景：有六个人要出门，所有人出门后关门
 * @author kangJia
 * @date 2021/1/16 19:25
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        // 总数是 6
        CountDownLatch count = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " - Go Out");
                count.countDown();
            }, String.valueOf(i)).start();
        }
        count.await();
        System.out.println("close door");
    }
}
