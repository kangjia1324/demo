package com.example.demo.concurrent.demo04.unsafe;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 不安全集合
 *
 * 引发异常 java.util.ConcurrentModificationException
 * @author kangJia
 * @date 2021/1/16 16:22
 */
public class ListTest {
    public static void main(String[] args) {
          // 并发下 ArrayList 是不安全的
//        final ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 3));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法一： 使用 vector，不推荐使用。比起ArrayList，底层使用了 synchronized
//        final List<String> list = new Vector<>();
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 3));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法二、Collections.synchronizedList()
//        final List<String> list = Collections.synchronizedList(new ArrayList<>());
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 3));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }

        // 解决方法三、使用 JUC 包下的类 CopyOnWriteArrayList
            // 底层使用数组：private transient volatile Object[] array;
        // CopyOnWrite  写入时复制。 COW 计算机程序设计领域的一种优化策略：
        // 多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
        // 再写入的时候避免覆盖，造成数据问题
        // CopyOnWriteArrayList 比 Vector 牛逼在哪里？
        // 看源码：前者使用 lock 锁；后者使用 synchronized

        final List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 3));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
