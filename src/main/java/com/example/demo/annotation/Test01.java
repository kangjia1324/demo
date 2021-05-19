package com.example.demo.annotation;

/**
 * @author kangJia
 * @date 2021/1/19 15:27
 */
@SuppressWarnings("all")
public class Test01 {

//    @Override  重写的注解
    @Override
    public String toString() {
        return super.toString();
    }

//    @Deprecated  不推荐程序员使用，或者存在更好的方式，但是可以使用，
    @Deprecated
    public static void test() {
        System.out.println("Deprecated");
    }
//  SuppressWarnings   抑制编译时期的警告
    @SuppressWarnings("all")
    public static void test2() {
        System.out.println("hello");
    }


    public static void main(String[] args) {
        test();
    }

}
