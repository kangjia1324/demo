package com.example.demo.concurrent.demo04.unsafe;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kangJia
 * @date 2021/1/16 16:58
 */
public class MapTest {
    public static void main(String[] args) {
        // map构造方法有两个参数，(int initialCapacity, float loadFactor)
        // 初始容量，默认是 1 << 4，
        // 加载因子，默认是 0.75f
        // 所以一下语句等于Map<String, Object> map = new HashMap<>(16, 0.75);
        // java.util.ConcurrentModificationException
//        final Map<String, Object> map = new HashMap<>();
//        for (int i = 0; i < 50; i++) {
//            new Thread(() -> {
//                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 4));
//                System.out.println(map);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法一：ConcurrentHashMap
        final Map<String, Object> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 4));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
}
