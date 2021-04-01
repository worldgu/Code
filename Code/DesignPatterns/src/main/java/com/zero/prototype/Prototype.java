package com.zero.prototype;

import lombok.Data;

/**
 * 基础数据类型测试
 *
 * @ClassName Prototype
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:06
 * @Version 1.0
 */
@Data
public class Prototype implements Cloneable {

    private int x = 8;


    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
}
