package com.zero.state;

/**
 *
 *                  状态模式（State）
 *
 * 状态模式也是一种行为型设计模式，它可以将一些相互间无关联的内容进行解耦，
 * 对于平时写出的一大堆的if else有优化作用，
 * 和策略模式有点相近，都是对不同的代码分支进行去耦合，
 * 但是不同的在于策略模式更加注重一套完整的策略解决方案，并不太关心原来入口处的逻辑，但
 * 是相对于策略模式来说，状态模式里有了一个Context的概念，状态的解耦合对象其实是一个固定的Context，其中不同的状态可能还会关心上下文中的一些方法结果
 *
 *
 * 打个比方，策略模式就好比，我去登录某个网站，网站给我的密码进行加密，用什么加密算法我不管，只要配置不同的策略就能自动切换对应的加密策略切可
 *
 *
 * 但是状态模式可能就是一个流程的审核分支，如果当前审核流程的节点是一个会签节点，那么就要根据节点的状态使用会签的逻辑，
 * 但会签时还需要知道当前流程的一个具体状态（是不是已经被别人审批过啦之类的），它与Context之间是有关联的
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:34
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new Pass());
        context.doSomeThing();
    }
}
