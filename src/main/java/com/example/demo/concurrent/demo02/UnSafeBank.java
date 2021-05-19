package com.example.demo.concurrent.demo02;

/**
 * 不安全的银行取钱
 * 两个人去银行取钱，账户
 * @author kangJia
 * @date 2021/1/15 14:19
 */
public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "结婚基金");

        Drawing you = new Drawing(account, 50, "you");
        Drawing wife = new Drawing(account, 100, "wife");

        you.start();
        wife.start();
    }
}
// 账户
class Account {
    int money; // 余额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行
class Drawing extends Thread{
    Account account; // 账户
    int drawingMoney; // 取了多少钱
    int nowMoney; // 现在手里还有多少钱

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {

        synchronized (account) {
            // 判断有没有钱
            if (account.money - drawingMoney < 0) {
                System.out.println("钱不够了");
                return;
            }
            try {
                Thread.sleep(1000); // 放大问题发生性
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 卡内余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;

            // 你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为：" + account.money);

            System.out.println(this.getName() + "手里的钱：" + nowMoney);

        }
    }
}