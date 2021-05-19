package com.example.demo.concurrent.demo01;

/**
 * 1. 建议线程正常停止
 * 2. 建议使用标志位——》设置一个标志位
 * 3. 不要使用 stop 或 destroy 等过时或者 JDK 不建议使用的方法
 * @author kangJia
 * @date 2021/1/15 11:15
 */
public class ThreadStop implements Runnable{
    // 1.设置一个标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag) {
            System.out.println("run……Thread" + i++);
        }
    }

    // 2. 设置一个公开的方法停止线程，转换标志位
    public void stop() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop stop = new ThreadStop();

        new Thread(stop).start();

        for (int i = 0; i < 5; i++) {
            System.out.println("main" + i);
            if (i==2) {
                stop.stop();
                System.out.println("线程该停止了");
            }
        }
    }
}
