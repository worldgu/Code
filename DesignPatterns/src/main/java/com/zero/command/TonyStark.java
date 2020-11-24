package com.zero.command;

/**
 *     妮妮本尼
 *
 *      命令模式(Command)
 *
 *  命令模式的核心思想是将命令的发送者与命令的执行者进行了解耦，方便对二者进行扩展
 *
 * 其中有几个比较重点的角色
 *
 * 1.Command 即命令的接口或者抽象，所有的命令由其扩展
 *
 * 2.Receiver 命令的接收者，执行者，它负责对由Command扩展出来的命令做出具体的执行操作
 *
 * 3.ConcreteCommand 译成中文为–具体命令，由Command扩展而来，定义某个具体的命令，内部持有一个recevier对象，将Command和Receiver连接起来，起到一个桥梁作用，将具体的命令交给对应的命令接收者进行处理
 *
 * 4.Invoker 即命令的发送者，命令模式的方法入口，内部持有Command对象
 *
 * 5.Client 通常来讲，还有一个client,但是个人觉得不太重要，它只是一个具体的调用者了
 *
 * 整个调用流程为 Invoker >Command(ConcreteCommand 为具体实现) >Receiver ，即由invoker发起命令，指定某个确定的命令，由命令将调用逻辑递交给具体的执行者。
 *
 *
 * @ClassName TonyStark
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:14
 * @Version 1.0
 */
public class TonyStark {

    public static void main(String[] args) {
        // 创建命令的执行者
        Jarvis jarvis = new Jarvis();
        // 创建一个唤醒命令，这个命令交给jarvis执行
        Command command = new WakeUpCommand(jarvis);
        // 调用麦克风，把命令输入到麦克风里
        Mic invoker = new Mic(command);
        // 麦克风唤醒远端的jarvis服务器
        invoker.invoke();
    }
}
