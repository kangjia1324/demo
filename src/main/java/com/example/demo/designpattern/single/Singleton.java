package com.example.demo.designpattern.single;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 19:20
 */
public class Singleton {

    private static final Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
