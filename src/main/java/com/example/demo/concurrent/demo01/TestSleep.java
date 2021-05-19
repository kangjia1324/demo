package com.example.demo.concurrent.demo01;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleep 模拟倒计时
 * @author kangJia
 * @date 2021/1/15 12:21
 */
public class TestSleep {
    public static void main(String[] args) throws InterruptedException {
        //        timeDown(20); //模拟倒计时 10，9，8，7，6，5，4，3，2，1
        // 获取系统当前时间
        Date startTime = new Date(System.currentTimeMillis());
        while (true) {
            final String format = new SimpleDateFormat("HH:mm:ss").format(startTime);
            System.out.println(format);
            Thread.sleep(1000);
            startTime = new Date(System.currentTimeMillis());
        }
    }

    // 模拟倒计时
    public static void timeDown(int num) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num<=0) {
                break;
            }
        }
    }
}
