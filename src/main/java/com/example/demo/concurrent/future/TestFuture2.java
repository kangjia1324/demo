package com.example.demo.concurrent.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 异步回调：CompletableFuture。类似于 ajax
 * 异步执行、成功回调、失败回调
 *
 * @author kangJia
 * @date 2021/1/18 11:20
 */
public class TestFuture2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 有返回值的异步回调
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "supplyAsync =》 Integer");
//            System.out.println(1 / 0);
            return 1024;
        });

        System.out.println(future.whenComplete((t, u) -> {
            System.out.println("t: " + t); // 正常的返回结果
            System.out.println("u: " + u);  // 错误信息
        }).exceptionally((e) -> {
            System.out.println(e.getMessage());
            return 233;  // 可以获取到错误的返回结果
        }).get());
    }
}
