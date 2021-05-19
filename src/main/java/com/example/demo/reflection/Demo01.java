package com.example.demo.reflection;

/**
 * @author kangJia
 * @date 2021/1/19 16:06
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过 反射获取类的 Class 对象
        Class c1 = Class.forName("com.example.demo.reflection.User");
        System.out.println(c1);

        // 一个类在内存中只有一个 Class 对象
        // 一个类被加载后，类的整个结构都会被封装在 class 对象中
        Class c2 = Class.forName("com.example.demo.reflection.User");
        Class c3 = Class.forName("com.example.demo.reflection.User");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());
    }
}
class User{
    private int id;
    private String name;
    private int age;

    public User() {
    }

    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
