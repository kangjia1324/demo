package com.example.demo.base.enum1;

import java.util.Arrays;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/4 10:38
 */
class Season1 {
    public static final int SPRING = 0;
    public static final int SUMMER = 1;
    public static final int AUTUMN = 2;
    public static final int WINTER = 3;
}
enum Season {
    SPRING, SUMMER, AUTUMN, WINTER
}
class App{
    public static void main(String[] args) {
        System.out.println(Season.SPRING);
        System.out.println(Season.valueOf(Season.SPRING.name()));
        System.out.println(Season.SPRING.name());
        System.out.println(Season.SPRING.ordinal());

        Arrays.stream(Season.values()).forEach(System.out::println);
    }
}