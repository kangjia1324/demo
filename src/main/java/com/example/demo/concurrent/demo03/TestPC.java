package com.example.demo.concurrent.demo03;

/**
 * 生产者消费者模式——管程法
 * @author kangJia
 * @date 2021/1/15 15:54
 */
public class TestPC {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();

        new Productor(container).start();
        new Consumer(container).start();
    }
}
class SynContainer{
    // 需要一个容器大小
    Milk[] milks = new Milk[10];
    // 容器计数器
    int count = 0;

    public synchronized void push(Milk milk) {
        // 如果容器满了，需要等待消费者消费
        if (count == milks.length) {
            // 生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 如果没有满，我们需要丢入产品
        milks[count] = milk;
        count++;

        // 可以通知消费者消费了
        this.notifyAll();
    }

    // 消费者消费产品
    public synchronized Milk pop() {
        // 判断能否消费
        if (count == 0) {
            // 消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果可以消费
        count--;
        Milk milk = milks[count];

        // 可以通知生产者生产
        this.notifyAll();
        return milk;
    }
}

// 生产者
class Productor extends Thread {
    SynContainer container;
    public Productor(SynContainer synContainer) {
        this.container = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            container.push(new Milk(i));
            System.out.println("生产了--" + i + "只鸡");
        }
    }
}
// 消费者
class Consumer extends Thread {
    SynContainer container;
    public Consumer(SynContainer synContainer) {
        this.container = synContainer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            System.out.println("消费了--" + container.pop().id + "只鸡");
        }
    }
}
// 产品
class Milk{
    int id; // 产品编号
    public Milk(int id) {
        this.id = id;
    }
}