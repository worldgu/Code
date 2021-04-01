package com.zero.templateMethod;

/**
 *      抽象类
 *
 * @ClassName AbstractTemplateMethod
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:38
 * @Version 1.0
 */
public abstract class AbstractTemplateMethod {

    protected abstract void getUp ();

    protected abstract void putOnClothes ();

    protected abstract void brushTeeth ();

    protected abstract void lockDoor ();

    public void getOut () {
        this.getUp();
        this.putOnClothes();
        this.brushTeeth();
        this.lockDoor();
    }


}
