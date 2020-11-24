package com.zero.state;

/**
 *      审核成功的操作
 *
 * @ClassName Pass
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:32
 * @Version 1.0
 */
public class Pass implements Audit {

    @Override
    public void doAudit() {
        System.out.println("审核通过");
    }
}
