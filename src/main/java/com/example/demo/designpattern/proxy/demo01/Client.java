package com.example.demo.designpattern.proxy.demo01;

/**
 *
 * @author kangJia
 * @date 2021/1/24 10:34
 */
public class Client {
    public static void main(String[] args) {
        // 房东要租房子
        Host host = new Host();
        // 代理，中介帮房东租房子。代理一般会有一些附属操作
        Proxy proxy = new Proxy(host);
        // 你不用面对房东，直接找中介租房即可
        proxy.rent();
    }
}
