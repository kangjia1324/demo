package com.example.demo.concurrent.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * 创建线程的方式二：实现 runnable 接口，重写 run 方法，创建 Thread 对象，调用 start 方法开启线程
 * 练习 runnable，多线程下载图片
 * @author kangJia
 * @date 2021/1/15 10:31
 */
public class TeatThread3 implements Runnable {
    private String url; // 网络图片地址
    private String name;  // 保存的文件名

    public TeatThread3(String url, String name) {
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
        final TestThread2 t1 = new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "1.jpg");
        final TestThread2 t2 = new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "2.jpg");
        final TestThread2 t3 = new TestThread2("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "3.jpg");

        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }
}
// 下载器
class WebDownLoader2 {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (IOException e) {
            System.out.println("下载方法出现异常" + e.getLocalizedMessage());
        }
    }
}