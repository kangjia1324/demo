package com.example.demo.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调：CompletableFuture。类似于 ajax
 * 异步执行、成功回调、失败回调
 *
 * @author kangJia
 * @date 2021/1/18 11:20
 */
public class TestFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 没有返回值的异步回调
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "runAsync =》Void");
        });

        System.out.println("main----");

        future.get();
    }
}
