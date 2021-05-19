package com.example.demo.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author kangJia
 * @date 2021/1/21 10:33
 */
public class Book {
    long id;
    public String name;
    protected int code;
    private double price;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", price=" + price +
                '}';
    }
}
/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 */
class BookTest{
    public static void main(String[] args) throws Exception{
        //1.获取Class对象
        Class bClass = Class.forName("com.example.demo.reflection.Book");

        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fieldArray = bClass.getFields();
        Arrays.stream(fieldArray).forEach(System.out::println);

        System.out.println("\n************获取所有的字段(包括公有、私有、受保护、默认的)********************");
        fieldArray = bClass.getDeclaredFields();
        Arrays.stream(fieldArray).forEach(System.out::println);

        System.out.println("\n*************获取公有字段 name 并调用***********************************");
        Field f = bClass.getField("name");
        System.out.println(f);
        //获取一个对象
        Object obj = bClass.getConstructor().newInstance();
        //为字段设置值
        f.set(obj, "《百年孤独》");
        //验证
        Book book = (Book)obj;
        System.out.println("验证书名：" + book.name);

        System.out.println("\n**************获取私有字段****并调用********************************");
        f = bClass.getDeclaredField("price");
        System.out.println(f);
        f.setAccessible(true);//暴力反射，解除私有限定
        f.set(obj, 100.00);
        System.out.println("验证价格：" + book);
    }
}