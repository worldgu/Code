package com.zero.strategy;

/**
 *
 *  策略模式接口
 *
 * @ClassName IStrategy
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 21:25
 * @Version 1.0
 */
public interface IStrategy {

    /**
     * 对数字进行计算
     *
     * @param number
     * @return
     */
    int calcThisNumber (int number);

    /**
     * 字符串拼接
     * @param string
     * @return
     */
    String addString (String string);

}
