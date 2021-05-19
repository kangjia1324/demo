package com.example.demo.concurrent.demo09;

import java.util.concurrent.RecursiveTask;

/**
 * Fork Join 框架
 * 求和计算，计算 1 到 10_0000_0000 的和
 * 三种方式，不同的效率！
 * @author kangJia
 * @date 2021/1/18 10:04
 */
public class TestForkJoin extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private Long temp = 1_0000L;

    public TestForkJoin(Long start, Long end) {
        this.start = start;
        this.end = end;
    }
    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else { // forkJoin
            long middle = (start + end) / 2;  // 中间值
            TestForkJoin task1 = new TestForkJoin(start, middle);
            task1.fork();  // 拆分任务，八任务压入线程队列
            TestForkJoin task2 = new TestForkJoin(middle + 1, end);
            task2.fork();  // 拆分任务，八任务压入线程队列

            return task1.join() + task2.join();
        }
    }
}
