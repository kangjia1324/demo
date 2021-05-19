package com.example.demo.base.datatype;

/**
 * @author kangJia
 * @date 2021/1/5 13:10
 */
public class ShortTest {

    public static void main(String[] args) {
        short s1 = 1;
        s1++;
        System.out.println(s1);  // 2
        // s1 = s1 +1; // 错误4
        s1 = (short) (s1 +1);
        System.out.println(s1);  // 3

        // float f1 = 3.1;  // 错误
        float f1 = (float) 3.8;
        System.out.println(f1);

        // 最有效率的方法计算 2 乘以 8
        int a = (2 << 3);  // 左移：相当于 2 ✖ （2的3次方）
        System.out.println(a);

        int b = (8 >> 3);  // 右移：相当于除以 2^3，即 8 ➗ （2的3次方）
        System.out.println(b);
    }
}
