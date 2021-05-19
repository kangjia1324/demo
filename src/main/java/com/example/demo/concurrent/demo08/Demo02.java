package com.example.demo.concurrent.demo08;

import java.util.concurrent.*;

/**
 * @author kangJia
 * @date 2021/1/17 21:10
 */
public class Demo02 {
    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        // 自定义线程池
        ExecutorService service = new ThreadPoolExecutor(
                2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()  // 队列满了，丢掉任务，不会抛出异常
//                new ThreadPoolExecutor.DiscardOldestPolicy()  //  队列满了，尝试丢掉和最早的竞争。不会抛出异常
//                new ThreadPoolExecutor.CallerRunsPolicy()  // 哪里来的去哪里
//                new ThreadPoolExecutor.AbortPolicy() // 银行满了，还有人进来，就不处理，并且抛出异常
        );

        try {
            // 最大承载  Deque + max
            // 超出了 java.util.concurrent.RejectedExecutionException
            for (int i = 0; i < 9; i++) {
                service.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " -Ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
