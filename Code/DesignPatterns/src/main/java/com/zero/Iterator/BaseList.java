package com.zero.Iterator;

/**
 * 定义一个容器接口
 *
 * @ClassName BaseList
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:06
 * @Version 1.0
 */
public interface BaseList<E> {

    /**
     * 添加容器
     *
     * @param e
     */
    void add (E e);

    /**
     * 获取容器
     *
     * @param i
     * @return
     */
    E get (int i);

    /**
     * 获取迭代器
     * @return
     */
    MyIterator<E> intertor ();
}
