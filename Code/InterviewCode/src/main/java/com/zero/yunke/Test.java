package com.zero.yunke;

/**
 *@ClassName Test
 *@Description TODO
 *@Author 张春海
 *@Date 2020/7/17 22:46 
 *@Version 1.0 */
public class Test extends TestA{

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        System.out.println("Test");
    }

    { System.out.println("I'm Test class");}

    static { System.out.println("static Test");}
}

class TestA {
    public TestA () {
        System.out.println("TestA");
    }

    { System.out.println("I'm TestA class");}

    static { System.out.println("static TestA");}
}

/**
 *  >>>>>>>   运行前答案
 *  TestA
 *  Test
 *  I'm TestA class
 *  static TestA
 *  I'm Test class
 *  static Test
 *
 *
 *  >>>>>>>>>  实际答案
 *  static TestA
 *  static Test
 *  I'm TestA class
 *  TestA
 *  I'm Test class
 *  Test
 *
 *
 *
 *  TODO: 理解
 *  static 语句块的执行优先级最高
 *  普通的语句块次之
 *  构造方法最低
 **/

