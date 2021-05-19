package com.example.demo.concurrent.demo04.unsafe;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author kangJia
 * @date 2021/1/16 16:45
 */
public class SetTest {
    public static void main(String[] args) {
        // 不安全的 HashSet，java.util.ConcurrentModificationException
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                set.add(UUID.randomUUID().toString().substring(0, 3));
//                System.out.println(set);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法一：使用工具类：Collections.synchronizedSet()
//        Set<String> set = Collections.synchronizedSet(new HashSet<>());
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                set.add(UUID.randomUUID().toString().substring(0, 3));
//                System.out.println(set);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法二：使用 JUC 包下的 CopyOnWriteArraySet
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
    }
}
