package com.example.demo.concurrent.demo02;

/**
 * 不安全的买票
 * @author kangJia
 * @date 2021/1/15 14:07
 */
public class UnSafeTicket {
    public static void main(String[] args) {
        final BuyTicket buyTicket = new BuyTicket();
        new Thread(buyTicket, "小明").start();
        new Thread(buyTicket, "老师").start();
        new Thread(buyTicket, "黄牛").start();
    }

}
class BuyTicket implements Runnable {
    // 票
    private int ticketNums = 6;
    private boolean flag = true;  // 外部停止方式

    @Override
    public void run() {
        while (flag) {
            buy();
        }
    }
    private void buy() {
        // 判断是否有票
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        // 模拟延时，放大问题的发生性
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 买票
        System.out.println(Thread.currentThread().getName()+ "拿到" +ticketNums--);
    }
}
