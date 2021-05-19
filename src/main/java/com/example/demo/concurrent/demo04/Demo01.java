package com.example.demo.concurrent.demo04;

import java.io.IOException;

/**
 * @author kangJia
 * @date 2021/1/16 13:27
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
//        Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
        // 获取 CPU 核数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
