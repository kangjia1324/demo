package com.example.demo.concurrent.atomic1;

import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 14:13
 */
public class Demo03 {
    static class User {
        private String name;
        private int old;
        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }

    public static AtomicReference<User> userAtomicReference = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("conan", 15);
        userAtomicReference.set(user);
        User newUser = new User("zhangsan", 20);
        userAtomicReference.compareAndSet(user, newUser);

        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getOld());
    }
}
