package com.example.demo.designpattern.single.kuangshen;

/**
 * 饿汉式
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 20:02
 */
public class Hungry {
    // 上来直接创建出单例类
    private final static Hungry HUNGRY = new Hungry();

    // 构造器私有化
    private Hungry() {}

    // 对外访问接口
    public static Hungry getInstance() {
        return HUNGRY;
    }

}
