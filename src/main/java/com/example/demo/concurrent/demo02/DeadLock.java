package com.example.demo.concurrent.demo02;

/**
 * 死锁：多个线程互相抱着对方需要的资源，不放手，形成僵持
 * @author kangJia
 * @date 2021/1/15 14:58
 */
public class DeadLock {
    public static void main(String[] args) {
        new Makeup(0, "灰姑娘").start();
        new Makeup(1, "白雪公主").start();
    }
}
// 口红
class Lipstick {}

// 镜子
class Mirror {}

// 化妆
class Makeup extends Thread {
    // 需要的资源只有一份，使用 static 来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int choice; // 选择
    String name; // 使用化妆品的人

    Makeup(int choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    @Override
    public void run() {
        // 化妆
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 化妆，互相持有对方的锁
    private void makeup() throws InterruptedException {
        if (choice == 0) {
            synchronized (lipstick) { // 获得口红的锁
                System.out.println(this.getName() + "获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror) { // 一秒钟后想获得镜子的锁
                System.out.println(this.getName() + "获得镜子的锁");
            }
        } else {
            synchronized (mirror) { // 获得镜子的锁
                System.out.println(this.getName() + "获得镜子的锁");
                Thread.sleep(1000);
            }
            synchronized (lipstick) { // 一秒钟后想获得口红的锁
                System.out.println(this.getName() + "获得口红的锁");
            }
        }
    }
}
