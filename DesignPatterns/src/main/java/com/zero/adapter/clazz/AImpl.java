package com.zero.adapter.clazz;

/**
 * @ClassName AImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 16:35
 * @Version 1.0
 */
public class AImpl implements InterfaceA {

    private Person person;

    public AImpl(Person person) {
        this.person = person;
    }

    @Override
    public String saySomething(String xxx) {
        return this.person.print();
    }
}
