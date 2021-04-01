package com.zero.juc.c_025;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName T03_SynchronizedList
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/15 21:54
 * @Version 1.0
 */
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> strsSync = Collections.synchronizedList(strs);
    }
}
