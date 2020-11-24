package com.zero.chainOfResponsibility;

/**
 * @ClassName PermissionFilter
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:52
 * @Version 1.0
 */
public class PermissionFilter implements Filter {

    private Filter next;

    @Override
    public void doFilter() {
        System.out.println("当前用户未注册，不允许访问");
        // 处理截止，不用调用next.doFilter;
    }

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }
}
