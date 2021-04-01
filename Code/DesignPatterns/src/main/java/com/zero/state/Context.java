package com.zero.state;

/**
 * @ClassName Context
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:28
 * @Version 1.0
 */
public class Context {

    private Audit audit;

    public Context () {

    }

    public void setState (Audit audit) {
        this.audit = audit;
    }

    public Audit getState () {
        return this.audit;
    }

    public void doSomeThing () {
        System.out.println("执行状态方法前有自己的逻辑");
        audit.doAudit();
        System.out.println("根据返回又可能有自己的处理");
    }
}
