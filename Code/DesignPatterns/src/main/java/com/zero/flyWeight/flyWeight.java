package com.zero.flyWeight;

/**
 *              享元模式    FlyWeight
 *
 *   享元模式 更多的应该算是一种思想，即对可复用资源的重复利用，
 *
 *   例如java的字符串常量池，数据库连接池，线程池的等等相关的池化技术都可以算是对享元设计模式的一种运用
 *
 * @ClassName flyWeight
 * @Description TODO
 * @Author 张春海
 * @Date 2020/11/23 20:38
 * @Version 1.0
 */
public class flyWeight {

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";

        String s3 = new String("abc");
        String s4 = new String("abc");

        String s5 = new String("ab");
        String s6 = new String("c");

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3.intern());
        System.out.println(s3.intern() == s4.intern());
        System.out.println(s1 == (s5 + s6));
        System.out.println(s1 == new String(s5 + s6).intern());

        /**
         * true
         * false
         * false
         * false     true
         * true
         * false
         * true
         *
         */
    }
}
