package com.example.demo.concurrent.utils;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 16:16
 */
public class CountDownLatchTest01 {

    public static void main(String[] args) throws InterruptedException {
        final Thread parse1 = new Thread(() -> { });
        final Thread parse2 = new Thread(() -> { });
        final Thread parse3 = new Thread(() -> { });

        parse1.start();
        parse2.start();
        parse3.start();

        parse1.join();
        parse2.join();
        parse3.join();

        System.out.println("所有的 sheet 都已解析解析完毕");
    }
}
