package com.zero.templateMethod;

/**
 * @ClassName DefaultTemplateMethod
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:40
 * @Version 1.0
 */
public class DefaultTemplateMethod extends AbstractTemplateMethod {

    @Override
    protected void getUp() {
        System.out.println("getUp");
    }

    @Override
    protected void putOnClothes() {
        System.out.println("putOnClothes");
    }

    @Override
    protected void brushTeeth() {
        System.out.println("brushTeeth");
    }

    @Override
    protected void lockDoor() {
        System.out.println("lockDoor");
    }
}
