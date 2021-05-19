package com.example.demo.concurrent.demo01;

/**
 *
 * 静态代理学习与理解
 * 总结：
 *      真实对象和代理对象要实现同一个接口，代理对象要代理真实角色
 * 好处：
 *      代理对象可以做更多真实对象做不了的事情
 *      真实对象专注做自己的事情
 * @author kangJia
 * @date 2021/1/15 11:00
 */
public class StaticProxy {
    public static void main(String[] args) {

        final You you = new You();
//        you.happyMarry();

        WeddingCompany company = new WeddingCompany(you);
        company.happyMarry();
    }
}
// 代理角色，帮助你结婚
class WeddingCompany implements Marry {

    // 要代理谁——真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        before();
        target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后，收尾款");
    }

    private void before() {
        System.out.println("结婚之前，布置场景");
    }
}

class You implements Marry{
    @Override
    public void happyMarry() {
        System.out.println("要结婚啦，好开心！");
    }
}

// 结婚接口
interface Marry{
    void happyMarry();
}
