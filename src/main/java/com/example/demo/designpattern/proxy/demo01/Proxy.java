package com.example.demo.designpattern.proxy.demo01;

/**
 * 代理角色：中介
 * @author kangJia
 * @date 2021/1/24 10:34
 */
public class Proxy implements Rent{
    private Host host;

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }

    @Override
    public void rent() {
        seeHouse();
        host.rent();
        heTong();
        fare();
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
