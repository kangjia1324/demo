package com.example.demo.designpattern.proxy.demo02;

/**
 * @author kangJia
 * @date 2021/1/24 10:48
 */
public class Client {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy =  new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.select();
    }
}
