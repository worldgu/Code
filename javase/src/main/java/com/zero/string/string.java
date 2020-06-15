package com.zero.string;

import java.lang.reflect.Field;

/**
 *@ClassName string
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/15 16:51 
 *@Version 1.0 */
public class string {

    public static void main(String[] args) throws NoSuchFieldException {
        String string = "as";
        Field[] fields = string.getClass().getFields();
        System.out.println(string.getClass().getField("hash"));

        StringBuffer sb = new StringBuffer();
        StringBuilder sbder = new StringBuilder();
    }
}
