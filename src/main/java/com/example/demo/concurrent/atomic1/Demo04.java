package com.example.demo.concurrent.atomic1;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/31 14:13
 */
public class Demo04 {
    static class User {
        private String name;
        public volatile int old;
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

    private static AtomicIntegerFieldUpdater<User> a = AtomicIntegerFieldUpdater.newUpdater(User.class, "old");

    public static void main(String[] args) {
        User user = new User("conan", 15);

        System.out.println(a.getAndIncrement(user));
        System.out.println(a.get(user));
    }
}
