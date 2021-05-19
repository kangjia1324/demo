package com.example.demo.concurrent.demo07;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * 同步队列 SynchronousQueue
 * 和其他的 BlockingQueue 不同，SynchronousQueue不存储元素
 * put 了一个值，必须从里面先 take 出来，否则不能再 put 进去值
 * @author kangJia
 * @date 2021/1/16 20:50
 */
public class TestSynchronousQueue {
    public static void main(String[] args) {
        // 同步队列
        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();

        new Thread(() -> {
            try {
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName() + "put 1");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName() + "put 2");
                blockingQueue.put("3");
                System.out.println(Thread.currentThread().getName() + "put 3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName() + " take " + blockingQueue.take());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "T2").start();


    }
}
