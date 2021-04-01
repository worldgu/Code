package com.zero.command;

/**
 *
 *              钢铁侠随身携带的迷你耳机
 *
 * @ClassName Mic
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:12
 * @Version 1.0
 */
public class Mic {

    private Command command;

    public Mic(Command command) {
        this.command = command;
    }

    public void invoke () {
        System.out.println("麦克风向远程服务器传输命令");
        command.execute();
    }
}
