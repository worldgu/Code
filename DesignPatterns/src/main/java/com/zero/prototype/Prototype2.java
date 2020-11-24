package com.zero.prototype;

import lombok.Data;

/**
 * String 操作
 *
 * @ClassName Prototype
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:06
 * @Version 1.0
 */
@Data
public class Prototype2 implements Cloneable {

    private String x = "test";


    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
}
