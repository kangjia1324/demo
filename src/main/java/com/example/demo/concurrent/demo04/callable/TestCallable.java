package com.example.demo.concurrent.demo04.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author kangJia
 * @date 2021/1/16 19:15
 */
public class TestCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        new Thread(new Runnable()).start();
//        new Thread(new FutureTask<V>()).start();
//        new Thread(new FutureTask<V>(Callable)).start();
        // 怎么启动 Callable
        A a = new A();
        FutureTask futureTask = new FutureTask(a);
        new Thread(futureTask, "A").start();
        new Thread(futureTask, "B").start(); // 结果会缓存，效率高

        final String s = (String) futureTask.get();  // 这个 get 方法可能产生阻塞，把它放到最后或者使用异步通信来处理
        System.out.println(s);
    }
}

class A implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call()");
        return "call--------";
    }
}
