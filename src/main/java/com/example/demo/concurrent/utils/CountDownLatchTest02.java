package com.example.demo.concurrent.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 16:16
 */
public class CountDownLatchTest02 {

    static CountDownLatch c = new CountDownLatch(2);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println(1);
            c.countDown();
            System.out.println(2);
            c.countDown();
        }).start();
        c.await();
        System.out.println(3);
    }
}
