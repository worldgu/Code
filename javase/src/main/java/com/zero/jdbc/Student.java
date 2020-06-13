package com.zero.jdbc;/**
 * Created by 张春海 on 2020/6/12  18:43
 */

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

/**
 *@ClassName Student
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/12 18:43 
 *@Version 1.0 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Student {

    private int id;
    private String name;
    private int age;
    private double score;
    private Date enterDate;

    public Student(int id, String name, int age, double score, Date enterDate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
        this.enterDate = enterDate;
    }
}
