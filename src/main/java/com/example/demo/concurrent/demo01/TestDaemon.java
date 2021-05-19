package com.example.demo.concurrent.demo01;

/**
 * @author kangJia
 * @date 2021/1/15 13:49
 */
public class TestDaemon {
    public static void main(String[] args) {
        final God god = new God();
        final My my = new My();

        final Thread godThread = new Thread(god);
        godThread.setDaemon(true);  // 默认是 false，即用户现场
        godThread.start(); // 上帝守护线程启动

        new Thread(my).start(); // 用户线程启动
    }
}
// 你自己
class My implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("难受的活着");
        }
        System.out.println("-----------我死啦---------------");
    }
}
// 上帝
class God implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("上帝无休止地疯狂滴嘲笑着这世间");
        }
    }
}