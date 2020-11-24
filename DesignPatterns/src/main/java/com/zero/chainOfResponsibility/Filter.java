package com.zero.chainOfResponsibility;

/**
 *
 *   接口定义
 *
 *
 * @ClassName Filter
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:48
 * @Version 1.0
 */
public interface Filter {

    void doFilter ();

    void setNext (Filter filter);

}
