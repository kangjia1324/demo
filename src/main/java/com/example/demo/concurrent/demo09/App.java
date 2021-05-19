package com.example.demo.concurrent.demo09;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * 解法一：普通程序员，直接 for 循环
 * 解法二：良好程序员，ForkJoin 框架，使用 ForkJoin ：
 *      1. ForkJoinPool，通过它来执行
 *      2. 计算任务 forkJoinPool.execute(ForkJoinTask tas
 *      3. 计算类要继承 ForkJoinTask
 * 解法三：高手！Stream 并行流
 * @author kangJia
 * @date 2021/1/18 10:33
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        test2();
        test3();
    }
    // 普通程序员
    public static void test1() {
        Long sum = 0L;
        final var startTime = System.currentTimeMillis();
        for (long i = 0; i <= 10_0000_0000L; i++) {
            sum += i;
        }
        final var endTime = System.currentTimeMillis();
        final long l = endTime - startTime;
        System.out.println("for 循环：sum = " + sum + "  用时：" + l);
    }

    // 优秀程序员
    public static void test2() throws ExecutionException, InterruptedException {
        Long sum = 0L;
        final var startTime = System.currentTimeMillis();

        TestForkJoin task = new TestForkJoin(0L, 10_0000_0000L);
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> submit = pool.submit(task);
        sum = submit.get();

        final var endTime = System.currentTimeMillis();
        final long l = endTime - startTime;
        System.out.println("ForkJoin 框架：sum = " + sum + "  用时：" + l);
    }

    // 高手
    public static void test3() {
        Long sum = 0L;
        final var startTime = System.currentTimeMillis();
        sum = LongStream.rangeClosed(0, 10_0000_0000L).parallel()
                .sum();
        final var endTime = System.currentTimeMillis();
        final long l = endTime - startTime;
        System.out.println("Stream 并行流：sum = " + sum + "  用时：" + l);
    }
}
