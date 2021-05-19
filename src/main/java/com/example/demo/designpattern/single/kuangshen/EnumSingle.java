package com.example.demo.designpattern.single.kuangshen;

import java.lang.reflect.Constructor;

/**
 * 枚举本身也是一个类，反射不能破坏枚举的单例
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 20:22
 */
public enum EnumSingle {
    INSTANCE;

    public EnumSingle getInstance() {
        return INSTANCE;
    }
}
class Test {
    public static void main(String[] args) throws Exception {
        final EnumSingle instance1 = EnumSingle.INSTANCE;

        final Constructor<EnumSingle> declaredConstructor = EnumSingle.class.getDeclaredConstructor(String.class, int.class);
        declaredConstructor.setAccessible(true);
        final EnumSingle instance2 = declaredConstructor.newInstance();

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }
}
