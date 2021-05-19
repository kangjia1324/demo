package com.example.demo.concurrent.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 练习 Thread，多线程下载图片
 * @author kangJia
 * @date 2021/1/15 10:09
 */
public class TestThread2 extends Thread {
    private String url; // 网络图片地址
    private String name;  // 保存的文件名

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader downLoader = new WebDownLoader();
        downLoader.downloader(url, name);
        System.out.println("您下载了名为：" + name + "的文件");
    }

    public static void main(String[] args) {
        new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "1.jpg").start();
        new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "2.jpg").start();
        new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "3.jpg").start();
    }
}
// 下载器
class WebDownLoader {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (IOException e) {
            System.out.println("下载方法出现异常" + e.getLocalizedMessage());
        }
    }
}