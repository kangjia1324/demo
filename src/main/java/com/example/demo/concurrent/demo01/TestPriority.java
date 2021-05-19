package com.example.demo.concurrent.demo01;

/**
 * 测试线程的优先级
 * @author kangJia
 * @date 2021/1/15 13:37
 */
public class TestPriority {
    public static void main(String[] args) {
        System.out.println("主线程的默认优先级" + Thread.currentThread().getName() + "--" + Thread.currentThread().getPriority());
        MyPriority priority = new MyPriority();

        Thread t1 = new Thread(priority);
        Thread t2 = new Thread(priority);
        Thread t3 = new Thread(priority);
        Thread t4 = new Thread(priority);
        Thread t5 = new Thread(priority);
        Thread t6 = new Thread(priority);

        // 先设置优先级，再启动
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(4);
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY);
        t4.start();

        t5.setPriority(-1);
        t5.start();

        t6.setPriority(11);
        t6.start();

    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "---" + Thread.currentThread().getPriority());
    }
}
