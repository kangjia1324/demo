package com.example.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author kangJia
 * @date 2021/1/21 10:26
 */
public class Person {
    private long id;
    private String name;
    private boolean sex;

    // 1、默认的构造方法
    Person(long id, String name, boolean sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    // 2、无参的构造方法
    public Person() {
    }

    // 3、一个参数的构造方法
    public Person(long id) {
        this.id = id;
    }

    // 4、多个参数的构造方法
    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 5、受保护的构造方法
    protected Person(boolean sex) {
        this.sex = sex;
    }

    // 6、私有的构造方法
    private Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}

// 测试类
class PersonTest{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //1.加载Class对象
        Class clazz = Class.forName("com.example.demo.reflection.Person");

        //2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] conArray = clazz.getConstructors();
        Arrays.stream(conArray).forEach(System.out::println);

        // 3、获取所有的构造方法
        System.out.println("\n**************所有的构造方法(包括：私有、受保护、默认、公有)***************");
        conArray = clazz.getDeclaredConstructors();
        Arrays.stream(conArray).forEach(System.out::println);

        // 4、获取公有、无参的构造方法，并调用
        System.out.println("\n******************获取公有、无参的构造方法*******************************");
        Constructor con = clazz.getConstructor();
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。

        System.out.println("con = " + con);

        // 调用构造方法
        Object obj = con.newInstance();

        // 5、获取私有的构造方法，并调用
        System.out.println("\n******************获取私有构造方法，并调用*******************************");
        con = clazz.getDeclaredConstructor(String.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);//暴力访问(忽略掉访问修饰符)
        obj = con.newInstance("kangjia");

        Person person = (Person) obj;
        System.out.println(person);
    }
}