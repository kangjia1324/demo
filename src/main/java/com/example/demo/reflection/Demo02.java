package com.example.demo.reflection;

import java.lang.reflect.Method;

/**
 * 测试性能分析
 * @author kangJia
 * @date 2021/1/21 10:41
 */
public class Demo02 {

    public static void main(String[] args) throws Exception {
        Pig pig = new Pig();

        // 直接调用 setName 方法
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            pig.setName("佩奇");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("直接调用 setName 方法用时：" + (endTime - startTime) + "ms");

        // 反射调用 setName 方法
        final Method method = pig.getClass().getMethod("setName", String.class);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            method.invoke(pig, "佩奇");
        }
        endTime = System.currentTimeMillis();
        System.out.println("反射调用 setName 方法用时：" + (endTime - startTime) + "ms");

        // 关掉安全检查反射调用 setName 方法
        method.setAccessible(true);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10_0000_0000; i++) {
            method.invoke(pig, "佩奇");
        }
        endTime = System.currentTimeMillis();
        System.out.println("关掉安全检查反射调用 setName 方法用时：" + (endTime - startTime) + "ms");



    }
}
class Pig{
    public void setName(String name) {

    }
}
