package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.util.concurrent.Executor;

/**
 * @ClassName T01_MyExecutor
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:13
 * @Version 1.0
 */
public class T01_MyExecutor  implements Executor {

    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        // new Thread(command).run();
        command.run();
    }
}
