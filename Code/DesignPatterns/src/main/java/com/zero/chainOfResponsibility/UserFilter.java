package com.zero.chainOfResponsibility;

/**
 *
 *      实现一
 *
 * @ClassName UserFilter
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:49
 * @Version 1.0
 */
public class UserFilter implements Filter{

    private Filter next;

    @Override
    public void doFilter() {
        System.out.println("用户身份认证通过");
        // 处理成功后，向后传递
        next.doFilter();
    }

    @Override
    public void setNext(Filter filter) {
        this.next = filter;
    }

}
