package com.example.demo.designpattern.single;

/**
 * 懒汉式单例
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 19:37
 */
public class LazySingleton {
    private static volatile LazySingleton instance = null;

    private LazySingleton() {}

    public static synchronized LazySingleton getInstance() {
        if (null == instance) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
