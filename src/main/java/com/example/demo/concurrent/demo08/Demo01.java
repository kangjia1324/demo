package com.example.demo.concurrent.demo08;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Executors 工具类，三大方法
 * @author kangJia
 * @date 2021/1/17 20:50
 */
public class Demo01 {
    public static void main(String[] args) {
//        final ExecutorService service = Executors.newSingleThreadExecutor();// 单个线程
//        final ExecutorService service = Executors.newFixedThreadPool(5);// 创建一个固定大小的线程池
        final ExecutorService service = Executors.newCachedThreadPool();// 可伸缩的，遇强则强，遇弱则弱

        try {
            for (int i = 0; i < 100; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " -OK");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
