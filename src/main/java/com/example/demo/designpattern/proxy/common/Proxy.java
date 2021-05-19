package com.example.demo.designpattern.proxy.common;

/**
 * 代理角色，它需要代理真实角色，然后替真实角色干完自己的事情，同时还可以做一些额外的处理
 * @author kangjia
 * @email 2466267753@qq.com
 * @date 2021/5/2 14:14
 */
public class Proxy implements Subject{

    // 要代理的角色
    private Subject subject = null;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    public Proxy() {
    }

    @Override
    public void request() {
        this.before();
        subject.request();
        this.after();
    }

    // 预处理
    private void after() {
    }

    // 善后处理
    private void before() {
    }
}
