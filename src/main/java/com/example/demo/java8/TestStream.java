package com.example.demo.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;

/**
 * 题目要求：一行代码实现：
 * 1. id 为偶数
 * 2. 年龄大于 23
 * 3. 用户名转为大写字母
 * 4. 用户名字母倒着排序
 * 5. 只输出一个用户
 * @author kangJia
 * @date 2021/1/17 16:10
 */
public class TestStream {
    public static void main(String[] args) {
        User user1 = new User(1, "a", 21);
        User user2 = new User(2, "b", 22);
        User user3 = new User(3, "c", 23);
        User user4 = new User(4, "d", 24);
        User user5 = new User(6, "e", 25);
        final List<User> users = Arrays.asList(user1, user2, user3, user4, user5);

        users.stream()
                .filter(u -> {return u.getId() % 2 == 0;})
                .filter(u -> {return u.getAge() > 23;})
                .map(u -> {return u.getName().toUpperCase();})
                .sorted((u1, u2) -> {
                    return u2.compareTo(u1);
                })
                .limit(1)
                .forEach(System.out::println);


    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private int id;
    private String name;
    private int age;
}
