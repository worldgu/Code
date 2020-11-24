package com.zero.Iterator;

/**
 * 定义具体的容器实现，
 *
 * 此处未考虑多出异常情况
 *
 * 仅为展示使用
 *
 * @ClassName MyList
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:08
 * @Version 1.0
 */
public class MyList<E> implements BaseList<E> {

    private int index = 0;

    // 初始化十个空的Object
    private Object[] objects = new Object[10];

    // 未考虑扩容问题
    @Override
    public void add(E e) {
        objects[index++] = e;
    }

    // 未考虑边界问题
    @Override
    public E get(int i) {
        return (E)objects[Math.max(i,index)];
    }

    @Override
    public MyIterator<E> intertor() {
        return new MyListInterator();
    }

    private class MyListInterator implements MyIterator<E> {

        private int nextIndex = 0;

        @Override
        public boolean hasNext() {
            if (nextIndex == 10) {
                return false;
            }
            return objects[nextIndex] != null;
        }

        @Override
        public E next() {
            return (E) objects[nextIndex++];
        }
    }
}
