package com.example.demo.designpattern.proxy.demo03;

/**
 * 真实角色：房东
 * @author kangJia
 * @date 2021/1/24 10:32
 */
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房东要出租房子");
    }
}
