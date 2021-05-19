package com.example.demo.concurrent.demo04;

/**
 * @author kangJia
 * @date 2021/1/16 14:01
 */
public class SaleTicket01 {
    public static void main(String[] args) {
        // 并发：多线程操作同一个资源类，把资源类丢入线程
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();

    }

}

class Ticket {
    // 属性、方法
    private int number = 30;

    // 买票的方式
    // synchronized 本质：队列，锁
    public synchronized void sale() {
        if (number >0) {
            System.out.println(
                    Thread.currentThread().getName() + "卖出了 " + number-- + " 票，剩余：" + number);
        }
    }
}
