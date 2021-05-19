package com.example.demo.concurrent.demo02;

import java.util.ArrayList;

/**
 * @author kangJia
 * @date 2021/1/15 14:34
 */
public class UnSafeList {
    public static void main(String[] args) {
        final ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
               list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
