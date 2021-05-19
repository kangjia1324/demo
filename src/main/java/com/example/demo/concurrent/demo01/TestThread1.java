package com.example.demo.concurrent.demo01;

/**
 * 创建线程的方式一：继承 Thread类，重写 run 方法，调用 start 方法开启线程
 * 总结：注意，下称开启不一定立即执行，由 CPU 调度执行
 * @author kangJia
 * @date 2021/1/15 9:59
 */
public class TestThread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        // main 线程，主线程

        // 创建一个线程对象
        TestThread1 thread1 = new TestThread1();
        // 调用 start 方法开启线程
        thread1.start();

        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程" + i);
        }
    }
}
