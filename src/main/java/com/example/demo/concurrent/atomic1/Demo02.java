package com.example.demo.concurrent.atomic1;

import com.example.demo.concurrent.demo04.pc.A;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 14:13
 */
public class Demo02 {
    static int[] value = new int[] {1, 2, 3};

    static AtomicIntegerArray aia = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        System.out.println(aia.getAndSet(0, 3));
        System.out.println(aia.get(0));
        System.out.println(value[0]);
    }
}
