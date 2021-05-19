package com.example.demo.concurrent.demo01;

/**
 * 测试 join ，可以想象成插队
 * @author kangJia
 * @date 2021/1/15 13:12
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("线程vip来了" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动我们的自定义线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 3; i++) {
            if (i == 2) {
                thread.join(); // 插队
            }
            System.out.println("main" + i);
        }
    }

}
