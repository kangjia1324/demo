package com.example.demo.designpattern.single;

/**
 * 饿汉式单例在类创建的同时就已经创建好一个静态的对象供系统使用，
 * 以后不再改变，所以是线程安全的，可以直接用于多线程而不会出现问题。
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 19:37
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return instance;
    }
}