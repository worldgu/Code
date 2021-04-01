package com.zero.state;

/**
 *      审核失败的操作
 *
 * @ClassName Fail
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:33
 * @Version 1.0
 */
public class Fail implements Audit{

    @Override
    public void doAudit() {
        System.out.println("审核不通过");
    }
}
