package com.zero.prototype;

import lombok.Data;
import lombok.ToString;

/**
 * 对象操作
 *
 * @ClassName Prototype
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 15:06
 * @Version 1.0
 */
@Data
public class Prototype3 implements Cloneable {

    private int y = 10;

    private CloneableObject object = new CloneableObject();



    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }

    @ToString
    private class CloneableObject implements Cloneable{

        private int x = 8;

        @Override
        public Object clone () throws CloneNotSupportedException {
            return super.clone();
        }


    }
}
