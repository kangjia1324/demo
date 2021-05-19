package com.example.demo.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author kangJia
 * @date 2021/1/21 10:39
 */
public class MyMain {
    public static void main(String[] args) {
        System.out.println("我的 MyMain 方法执行了。。。。。。" + Arrays.toString(args));
    }
}
class MyMainTest {
    public static void main(String[] args) {
        try {
            //1、获取Student对象的字节码
            Class clazz = Class.forName("com.example.demo.reflection.MyMain");

            //2、获取main方法
            //第一个参数：方法名称，第二个参数：方法形参的类型，
            Method methodMain = clazz.getMethod("main", String[].class);
            //3、调用main方法
            // methodMain.invoke(null, new String[]{"a","b","c"});
            //第一个参数，对象类型，因为方法是static静态的，所以为null可以，第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
            //这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
            methodMain.invoke(null, (Object)new String[]{"a","b","c"});//方式一
            // methodMain.invoke(null, new Object[]{new String[]{"a","b","c"}});//方式二
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}