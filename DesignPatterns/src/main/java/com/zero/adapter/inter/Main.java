package com.zero.adapter.inter;

/**
 *
 * 运用于在现有几套不同的组件，互相间的接口定义不一致，又期望让他们可以协同工作，可以通过实现一套适配器，让本身无法兼容的组件可以协同工作了
 *
 *
 * mybatis中兼容了很多日志组件，不同的日志组件中又定义了不同的日志级别，
 * 因此mybatis定义了一套标准的日志级别，然后针对不同的日志组件，开发一套不同的适配器，
 * 让兼容的日志组件得以对应到mybatis的日志级别上
 *
 *
 * 举个例子，你买了一个欧版水货数码产品，充电器的插头和国内的国标接口不一样，
 * 所以我们需要买一个转换头（适配器），让本来不能在国标插座上充电的设备能正常充电了
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:28
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        Adapter adapter = new Adapter();

        Long aLong = adapter.printLong(1L);

        System.out.println(aLong);
    }
}
