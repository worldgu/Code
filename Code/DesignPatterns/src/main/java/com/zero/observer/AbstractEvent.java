package com.zero.observer;

/**
 * 事件的抽象
 *
 * @ClassName AbstractEvent
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 21:22
 * @Version 1.0
 */
public abstract class AbstractEvent {

    /**
     *
     * 通常事件定义中都存在调用对象的引用，防止出现特殊情况在处理事件时要对调用者进行处理
     *
     */

    private IronMan source;

    public IronMan getSource(){
        return source;
    }

    public void setSource (IronMan source) {
        this.source = source;
    }

}
