package com.example.demo.java8;

import java.util.function.Predicate;

/**
 * Predicate 断定型接口，有一个输入参数T，输出为 布尔值
 * @author kangJia
 * @date 2021/1/16 21:28
 */
public class TestPredicate {
    public static void main(String[] args) {
        // 判断字符串是否为空
//        final Predicate<String> predicate = new Predicate<>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        // 上述代码简化版
//        Predicate<String> predicate = (s) -> {return s.isEmpty();};
        // 甚至简化为：
        Predicate<String> predicate = String::isEmpty;

        System.out.println(predicate.test(""));  // true
        System.out.println(predicate.test("hello"));  // false
    }
}
