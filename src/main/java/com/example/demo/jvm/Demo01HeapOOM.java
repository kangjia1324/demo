package com.example.demo.jvm;

import java.util.ArrayList;

/**
 * -Xms20m -Xmx20m
 * @author kangJia
 * @date 2021/1/2 15:04
 */
public class Demo01HeapOOM {
    static class OOMObject {}

    public static void main(String[] args) {
        var list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
/*
*
* Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at com.example.demo.jvm.Demo01HeapOOM.main(Demo01HeapOOM.java:17)
*
* */