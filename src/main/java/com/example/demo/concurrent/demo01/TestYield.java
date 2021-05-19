package com.example.demo.concurrent.demo01;

/**
 * @author kangJia
 * @date 2021/1/15 13:03
 */
public class TestYield {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();

        new Thread(myYield, "A").start();
        new Thread(myYield, "B").start();
    }
}
class MyYield implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程正在执行");
        Thread.yield(); // 礼让
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
