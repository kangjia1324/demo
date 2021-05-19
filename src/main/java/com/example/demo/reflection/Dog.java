package com.example.demo.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author kangJia
 * @date 2021/1/21 10:37
 */
public class Dog {

    public void dogSay1(String words) {
        System.out.println("调用了公有的，一个 String 参数的 dogSay1():" + words);
    }

    protected void dogSay3() {
        System.out.println("调用了受保护的，无参数 dogSay3():");
    }

    void dogSay2(String words) {
        System.out.println("调用了默认的、无参的 dogSay2():" + words);
    }

    private String dogSay4(String words) {
        System.out.println("调用了私有的，一个 String 参数的 dogSay4():" + words);
        return words;
    }
}

/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
 */
class DogTest {
    public static void main(String[] args) throws Exception{
        //1.获取Class对象
        Class dogClass = Class.forName("com.example.demo.reflection.Dog");

        //2.获取所有公有方法
        System.out.println("***************获取所有的公有方法*******************");
        Method[] methodArray = dogClass.getMethods();
        Arrays.stream(methodArray).forEach(System.out::println);

        System.out.println("\n***************获取所有的方法，包括私有的*******************");
        methodArray = dogClass.getDeclaredMethods();
        Arrays.stream(methodArray).forEach(System.out::println);

        System.out.println("\n***************获取公有的 dogSay1() 方法*******************");
        Method m = dogClass.getMethod("dogSay1", String.class);
        System.out.println(m);
        //实例化一个 Dog 对象
        Object obj = dogClass.getConstructor().newInstance();
        m.invoke(obj, "DogJay");

        System.out.println("\n***************获取私有的 dogSay4() 方法******************");
        m = dogClass.getDeclaredMethod("dogSay4", String.class);
        System.out.println(m);
        m.setAccessible(true);//解除私有限定
        Object result = m.invoke(obj, "DogDogDog");//需要两个参数，一个是要调用的对象（获取有反射），一个是实参
        System.out.println("返回值：" + result);
    }
}