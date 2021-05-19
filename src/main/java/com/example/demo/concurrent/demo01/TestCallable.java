package com.example.demo.concurrent.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * 创建线程方式三：实现 Callable 接口
 * @author kangJia
 * @date 2021/1/15 10:49
 */
public class TestCallable implements Callable<Boolean> {
    private String url; // 网络图片地址
    private String name;  // 保存的文件名

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownLoader downLoader = new WebDownLoader();
        downLoader.downloader(url, name);
        System.out.println("您下载了名为：" + name + "的文件");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final TestCallable t1 = new TestCallable("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "1.jpg");
        final TestCallable t2 = new TestCallable("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "2.jpg");
        final TestCallable t3 = new TestCallable("https://i0.hdslb.com/bfs/vc/da55fab2e559b4458ece1f92b9060d6e1bccaac7.jpg", "3.jpg");

        // 创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(1);

        // 提交执行
        final Future<Boolean> s1 = service.submit(t1);
        final Future<Boolean> s2 = service.submit(t2);
        final Future<Boolean> s3 = service.submit(t3);

        // 获取结果
        final Boolean b1 = s1.get();
        final Boolean b2 = s2.get();
        final Boolean b3 = s3.get();

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

        // 关闭服务
        service.shutdown();
    }
}
// 下载器
class WebDownLoader3 {
    // 下载方法
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));

        } catch (IOException e) {
            System.out.println("下载方法出现异常" + e.getLocalizedMessage());
        }
    }
}
