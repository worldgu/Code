package com.zero.Iterator;

/**
 *            迭代器模式（Iterator）
 *
 *  迭代器模式用的比较多，像List.iterator()就是使用的迭代器模式，
 *
 *  迭代器模式通常用于对于自已定义的容器设计一套遍历方案。因为自己创建实现的容器，
 *
 *  只有自己才清楚它的内存存储模型，因此也只有自己清楚对它的数据要进行如何遍历。
 *
 *  比如对于树结构，就有中序遍历，前序遍历，后序遍历，
 *
 *  因此，通过统一的迭代器接口，即可实现对同一接口抽象的统一遍历要求的封装
 *
 *
 *
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:15
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        BaseList<String> myList = new MyList<>();
        for (int i = 0; i < 10; i++) {
            myList.add("name" + i);
        }

        MyIterator<String> iterator = myList.intertor();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
