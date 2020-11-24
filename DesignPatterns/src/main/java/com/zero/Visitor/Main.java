package com.zero.Visitor;

/**
 *              访问者模式（Visitor）
 *
 *
 *  从设计原则上来说，它破了对象的封装性，因为访问者模式将被访问对象的相关属性暴露出来并可以操纵它们，即将对象的定义与它的操作进行了拆分
 *
 * 它适用于类的结构相对固定，但是类属性的操作经常发生变化的场景
 *
 * 如果某个类的属性结构时常发生变化 ，那第它一定不适用于访问者模式
 *
 *
 * 具体角色分工
 *
 * Visitor：定义为接口或者抽象类，封装了访问所有属性的方法的接口，也是因此要求被访问对象结构要稳定，否则维护成本太高，不适用于此模式
 *
 * ConcreteVisitor：具体的访问者对象，对应上面的Comsumer对象，在它里面定义了对被访问对象所有属性的操作方法
 *
 * AbstractElement：抽象出来的元素，对应上面的ComputePart,最重要的需要在里面定义一个accept(Visitor visitor)的方法，接受访问者对象对被访问元素的操作
 *
 * Element:具体的元素对象，就是通过accept()方法将自己暴露出去,接受访问者的操作
 *
 * ObjectStructure：对象结构体，即对应上面的Compute,起到定义具体对象的实际组成的作用
 *
 *
 * https://blog.csdn.net/m0_47210154/article/details/105778270
 *
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 22:55
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ComputeStore store = new ComputeStore();
        store.sell(new Comsumer());
    }
}
