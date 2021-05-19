package com.example.demo.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * 反射操作注解
 *
 * @author kangJia
 * @date 2021/1/21 10:57
 */
@MyTable("t_account")
public class Account {

    @MyField(columnName = "pid", type = "int", num = 10)
    private int id;

    @MyField(columnName = "_name", type = "varchar", num = 20)
    private String name;

}
class AccountTest{
    public static void main(String[] args) throws NoSuchFieldException {
        final Class<Account> c = Account.class;

        // 通过反射获得注解
        for (Annotation annotation : c.getAnnotations()) {
            System.out.println(annotation);
        }

        // 获得注解的 value
        final MyTable annotation = c.getAnnotation(MyTable.class);
        System.out.println(annotation.value());

        // 获取字段的注解
        final Field field = c.getDeclaredField("id");

        final MyField annotation1 = field.getAnnotation(MyField.class);
        System.out.println(annotation1);
        System.out.println(annotation1.columnName());
        System.out.println(annotation1.type());
        System.out.println(annotation1.num());

    }
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyTable{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyField{
    String columnName();
    String type();
    int num();
}