package com.example.demo.reflection;

/**
 * @author kangJia
 * @date 2021/1/21 10:25
 */
public class Student {
    private long id;
    private String username;
}

class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //1、通过对象调用 getClass() 方法来获取,通常应用在：比如你传过来一个 Object
        //  类型的对象，而我不知道你具体是什么类，用这种方法
        Student p1 = new Student();
        Class c1 = p1.getClass();

        //2、直接通过 类名.class 的方式得到,该方法最为安全可靠，程序性能更高
        //  这说明任何一个类都有一个隐含的静态成员变量 class
        Class c2 = Student.class;

        //3、通过 Class 对象的 forName() 静态方法来获取，用的最多，
        //   但可能抛出 ClassNotFoundException 异常
        Class c3 = Class.forName("com.example.demo.reflection.Student");

        // 对上面获取的 c1,c2,c3进行 equals 比较，发现都是true.一个类在 JVM 中只会有一个 Class 实例
        System.out.println(c1 == c2 && c2 == c3);  // true
    }
}
