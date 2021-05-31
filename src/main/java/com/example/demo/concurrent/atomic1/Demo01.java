package com.example.demo.concurrent.atomic1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 14:13
 */
public class Demo01 {

    static AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        System.out.print(ai.getAndIncrement() + "--------");
        System.out.println(ai.get());
    }
}
