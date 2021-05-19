package com.example.demo.designpattern.proxy.demo03;

/**
 * @author kangJia
 * @date 2021/1/24 11:36
 */
public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();

        // 代理角色：现在没有
        final ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setRent(host);
        final Rent proxy = (Rent) pih.getProxy();  // 这里的 proxy 就是动态生成的

        proxy.rent();

    }
}
