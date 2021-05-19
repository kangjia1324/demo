package com.example.demo.designpattern.single.kuangshen;

/**
 * 静态内部类，不安全，反射
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 20:15
 */
public class Holder {

    private Holder() {}

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }

    public static Holder getInstance() {
        return InnerClass.HOLDER;
    }
}
