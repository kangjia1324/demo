package com.example.demo.designpattern.proxy.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author kangJia
 * @date 2021/1/24 11:31
 */
public class ProxyInvocationHandler implements InvocationHandler {
    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    // 处理代理实例，并返回结果
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        seeHouse();
        // 动态代理的本质，就是使用反射机制实现
        final Object invoke = method.invoke(rent, args);
        heTong();
        fare();
        return invoke;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                rent.getClass().getInterfaces(),
                this);
    }

    // 看房
    public void seeHouse() {
        System.out.println("中介带你去看房");
    }
    // 签订租赁合同
    public void heTong() {
        System.out.println("签订租赁合同");
    }
    // 收中介费
    public void fare() {
        System.out.println("收中介费");
    }
}
