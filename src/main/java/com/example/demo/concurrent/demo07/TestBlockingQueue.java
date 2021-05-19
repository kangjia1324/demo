package com.example.demo.concurrent.demo07;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author kangJia
 * @date 2021/1/16 20:25
 */
public class TestBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }

    // 4. 等待，阻塞（超时阻塞）
    public static void test4() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.offer("a");
        blockingQueue.offer("b");
        blockingQueue.offer("c");

        // 假如第四个，阻塞，会等待2s，就退出
        blockingQueue.offer("d", 2, TimeUnit.SECONDS);

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        // 队列为空时，没有这个元素，等待超过两秒就退退出
        blockingQueue.poll(2, TimeUnit.SECONDS);
    }

    // 3. 等待，阻塞（一直阻塞）
    public static void test3() throws InterruptedException {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");

        // 添加第四个，队列没有位置了，一直阻塞
        blockingQueue.put("d");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());

        // 队列为空时，没有这个元素，一直阻塞
        System.out.println(blockingQueue.take());
    }

    // 2. 不抛出异常
    public static void test2() {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.peek());  // 检测队首元素

        // 添加第四个，会返回 false，没有异常
//        System.out.println(blockingQueue.offer("d"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());

        // 队列为空时，返回 null
        System.out.println(blockingQueue.poll());
    }

    // 1. 抛出异常
    public static void test1() {
        // 队列的大小
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);

        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        System.out.println(blockingQueue.element());  // 查看队首元素

        // 添加第四个：会抛出异常 java.lang.IllegalStateException
//        System.out.println(blockingQueue.add("d"));

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());

        // 空队列继续移除：抛出异常 java.util.NoSuchElementException
//        System.out.println(blockingQueue.remove());
    }
}
