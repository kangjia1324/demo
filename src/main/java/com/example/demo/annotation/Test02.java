package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * 元注解
 * @author kangJia
 * @date 2021/1/19 15:44
 */
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}
// 定义一个元注解
@Target(value = {ElementType.METHOD, ElementType.TYPE})  // Target 表示我们的注解可以用在那些地方
@Retention(RetentionPolicy.RUNTIME)  // 表示我们的注解在什么地方还有效 source < class < runtime
@Documented  // 表示是否将我们的注解生成在 JAVAdoc 中
@Inherited  // 子类可以继承父类的注解
@interface MyAnnotation{

}
