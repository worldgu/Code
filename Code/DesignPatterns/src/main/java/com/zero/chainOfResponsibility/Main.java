package com.zero.chainOfResponsibility;

/**
 *
 *              责任链模式    Chain of Responsibility
 *
 *  即将一组处理器通过串行化的方式组装在一起，共同来处理同一个对象，
 *
 *  这个对象具体会在哪一个处理器中进行处理是未知的，
 *
 *  可以方便的对不同的需求组织不同的处理器实现高度自由化的定制处理策略
 *
 *
 * 具体的实现方式有很多，主体思想还是要保证串行化，可打断，对功能可以灵活装卸，同时不对业务代码产生干扰，即把专业的事交给专业的人去做
 *
 *
 *  https://blog.csdn.net/m0_47210154/article/details/105721703
 *
 *
 * @ClassName MAIN
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 20:53
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // 组装成链，这个过程可以灵活配置
        Filter userFilter = new UserFilter();
        Filter permissionFilter = new PermissionFilter();
        userFilter.setNext(permissionFilter);
        // 执行头
        userFilter.doFilter();

    }

}
