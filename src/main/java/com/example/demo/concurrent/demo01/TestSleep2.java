package com.example.demo.concurrent.demo01;


/**
 * sleep 模拟倒计时
 * @author kangJia
 * @date 2021/1/15 12:21
 */
public class TestSleep2 implements Runnable {
    private int  ticketNum = 10;

    public static void main(String[] args) throws InterruptedException {
        final TestSleep2 testSleep2 = new TestSleep2();
        new Thread(testSleep2, "小明").start();
        new Thread(testSleep2, "老师").start();
        new Thread(testSleep2, "黄牛").start();
    }

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) break;
            try {
                // 模拟延时
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第  " + ticketNum-- + "  张票");
        }

    }
}
