package com.zero.Memento;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;

/**
 *          实现序列化接口
 *
 * @ClassName Person
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/24 23:44
 * @Version 1.0
 */
@Data
@ToString
public class Person implements Serializable {

    private static final long serivalVersionUID = -12349621452122L;

    private String name;

    private int age;

}
