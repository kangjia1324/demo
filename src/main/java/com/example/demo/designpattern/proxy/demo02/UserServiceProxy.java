package com.example.demo.designpattern.proxy.demo02;

/**
 * userService 的代理角色，可以在不改变原来功能的基础上，添加额外的功能
 * 改动原有的代码，在公司中是大忌
 * @author kangJia
 * @date 2021/1/24 10:49
 */
public class UserServiceProxy implements UserService{
    private UserServiceImpl userService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void select() {
        log("select");
        userService.select();
    }

    // 日志方法
    public static void log(String msg) {
        System.out.println("使用了 " + msg + "方法");
    }
}
