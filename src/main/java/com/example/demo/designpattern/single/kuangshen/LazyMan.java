package com.example.demo.designpattern.single.kuangshen;

/**
 * 懒汉式单例，双重检测锁，DCL。线程安全，但是反射可以破坏单例
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 20:05
 */
public class LazyMan {
    private volatile static LazyMan lazyMan;

    private LazyMan() {}

    // 双重检测锁模式的懒汉式单例，DCL 懒汉式
    public static LazyMan getInstance() {
        if (null == lazyMan) {
            synchronized (LazyMan.class) {
                if (null == lazyMan) {
                    lazyMan = new LazyMan();  // 不是一个原子性操作，见下
                }
            }
        }
        return lazyMan;
    }
}
/**
 * 1. 分配内存空间
 * 2. 执行构造方法，初始化对象
 * 3. 把这个对象指向这个空间
 *
 * 执行顺序可能为：123 、132
 */