package com.zero.Iterator;

/**
 * 定义一个迭代器
 *
 * @ClassName MyIterator
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:05
 * @Version 1.0
 */
public interface MyIterator<E> {

    boolean hasNext ();

    E next ();
}
