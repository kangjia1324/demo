package com.example.demo.concurrent.demo05;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author kangJia
 * @date 2021/1/16 19:40
 */
public class TestSemaphore {
    public static void main(String[] args) {
        // 线程数量：停车位! 限流
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                // semaphore.acquire(); 得到
                // semaphore.release();  释放
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + "离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
