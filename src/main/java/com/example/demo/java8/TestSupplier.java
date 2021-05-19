package com.example.demo.java8;

import java.util.function.Supplier;

/**
 * Supplier：没有参数，只有返回值
 * @author kangJia
 * @date 2021/1/16 21:49
 */
public class TestSupplier {
    public static void main(String[] args) {
//        final Supplier<Integer> supplier = new Supplier<>() {
//            @Override
//            public Integer get() {
//                return 1024;
//            }
//        };

        //  简化版
        final Supplier<Integer> supplier = () -> {return 1024;};

        System.out.println(supplier.get());
    }
}
