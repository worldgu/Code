package com.zero.proxy.stati;

/**
 * 定义静态代理类 ，在 跑步前进行热身，跑步后进行拉伸
 *
 * @ClassName HumanProxy
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 11:28
 * @Version 1.0
 */
public class HumanProxy implements Human {

    private Human human;

    public HumanProxy (Human human) {
        this.human = human;
    }

    @Override
    public void run() {
        System.out.println("开始热身------");
        human.run();
        System.out.println("开始拉伸------");
    }

}
