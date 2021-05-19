package com.example.demo.java8;

import java.util.function.Function;

/**
 * Function 函数式接口，有一个输入参数T，有一个输出R
 * 只要是函数型接口，就可以使用 lambda 表达式简化
 * @author kangJia
 * @date 2021/1/16 21:28
 */
public class TestFunction {
    public static void main(String[] args) {
        // 工具类：输出输入的值
//        Function<String, String> function = new Function<>() {
//            @Override
//            public String apply(String s) {
//                return s;
//            }
//        };
        // 上述代码简化版
        Function<String, String> function = (str) -> {return str;};

        System.out.println(function.apply("hello"));
    }
}
