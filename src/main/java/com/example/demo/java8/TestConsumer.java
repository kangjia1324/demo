package com.example.demo.java8;

import java.util.function.Consumer;

/**
 * 消费型接口
 * 只有输入，没有返回值
 * @author kangJia
 * @date 2021/1/16 21:49
 */
public class TestConsumer {
    public static void main(String[] args) {
//        final Consumer<String> consumer = new Consumer<>() {
//            @Override
//            public void accept(String str) {
//                System.out.println(str);
//            }
//        };

        // 简化版
//        Consumer<String> consumer = (str) -> {System.out.println(str);};
        // 甚至再简化
        Consumer<String> consumer = System.out::println;

        consumer.accept("hello");
    }
}
