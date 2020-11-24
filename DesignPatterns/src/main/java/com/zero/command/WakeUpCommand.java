package com.zero.command;

/**
 *          创建一个 唤醒 jarvis 的命令
 *
 * @ClassName WakeUpCommand
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:08
 * @Version 1.0
 */
public class WakeUpCommand implements Command {

    private Jarvis jarvis;

    public WakeUpCommand (Jarvis jarvis) {
        this.jarvis = jarvis;
    }


    @Override
    public void execute() {
        System.out.println("命令已经确认，将有Jarvis 执行");
        jarvis.action();
    }
}
