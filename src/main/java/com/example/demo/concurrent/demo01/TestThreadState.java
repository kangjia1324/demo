package com.example.demo.concurrent.demo01;

/**
 * @author kangJia
 * @date 2021/1/15 13:20
 */
public class TestThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("--------------------");
        });

        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state);  //NEW

        // 观察启动后
        thread.start();
        state = thread.getState();
        System.out.println(state); // NEW

        while (state != Thread.State.TERMINATED) { // 只要线程不终止
            Thread.sleep(1000);
            state = thread.getState(); // 更新状态
            System.out.println(state);
        }
    }
}
