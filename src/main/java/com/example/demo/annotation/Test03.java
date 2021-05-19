package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * @author kangJia
 * @date 2021/1/19 15:56
 */
public class Test03 {

    @MyAnnotation2(name = "kangJia", schools = {"清华大学"})
    public void test() {}

    @MyAnnotation3("kangJia")
    public void test2() {}
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    // 注解的参数：参数类型 + 参数名（）
    String name() default "";
    int age() default 0;
    int id() default -1;

    String[] schools() default {"清华大学", "北京大学"};
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    // 如果这里只有一个参数，默认使用 value，使用时可以省略
    String value();
}
