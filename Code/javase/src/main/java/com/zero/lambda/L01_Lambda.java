package com.zero.lambda;

import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

/**
 *
 * Lambda 表达式 lambda expression 是一个匿名函数
 * Lambda 表达式 集与数学中的λ演算得名，
 * 直接对应于其中的lambda抽象(lambda abstraction)，
 * 是一个匿名函数，即没有函数名的函数。Lambda表达式可以表示闭包
 * （注意和数学传统意义上的不同）。
 *
 * @ClassName L01_Lambda
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/5 0:27
 * @Version 1.0
 */
public class L01_Lambda {

    public static void main(String[] args) {
        /**
         * 基本语句
         */
        Runnable noArgunments = () -> System.out.println("hello");
        ActionListener oneArgument = event -> System.out.println("button clicked");
        Runnable multiStatement = () -> {
            System.out.println("hello");
            System.out.println("world");
        };
        BinaryOperator<Long> ad = (x,y) -> x + y;
        BinaryOperator<Long> addExplicit = (Long x,Long y) -> x + y;

        /**
         *
         * 编写线程
         */
        Runnable runnable = () -> {
            System.out.println("Lambda 创建线程");
        };
        Thread thread = new Thread(runnable);
        thread.start();

        /**
         * 利用Lambda运算
         */
        BinaryOperator<Integer> add = (x,y) -> x + y;
        Integer xy = add.apply(20,30);
        System.out.println("利用Lambda运算" + xy );

        /**
         * 统计数组中某元素出现的个数
         */
        String name[] = {"张三", "李四", "王五", "孙刘", "赵强", "李明", "赵强", "汪汪"};
//        long num = Arrays.stream(name).filter(x -> x.equals("赵强")).collect(Collectors.counting());


        long  num = Arrays.stream(name).filter(x -> x.equals("赵强")).collect(Collectors.counting());
        System.out.print("数组中赵强出现的次数 " +num);

//        Map<String, Object> extendParam =
//                Map.entrySet().stream()
//                        .filter(map -> "labels".equals(map.getKey()) || "annotations".equals(map.getKey()))
//                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        /**
         * 数组去重并转换为集合存储
         *
         */
        List<String> stringList = Arrays.stream(name).filter( x-> !x.equals("赵强")).collect(toList());
        System.out.println("数组中去重并返回结果:" + stringList.toString());

        /**
         * 数组去重，并对元素加后缀
         */
        List<String> stringList2 = Arrays.stream(name).filter( x-> !x.equals("赵强")).map(y -> y +"后缀").collect(toList());
        System.out.println("数组中去重添加后缀并返回结果:" + stringList2.toString());

        /**
         * 数组求和
         */
        int[] a = {1,2,3,4,5,6,7,8,9,10};
        int count  = 0;

        // for 循环
        for (int i = 0; i < a.length; i++) {
            count += a[i];
        }
        System.out.println("数组求和 " + count);

        // foreach
        count = 0;
        for (int i: a ) {
            count += a[i];
        }
        System.out.println("数组求和 " + count);

        count = 0;
        // Lambda
        int nums = Arrays.stream(a).reduce(0, (b,c) -> b+c);

        System.out.println("数组求和 " + nums);

        /**
         * Lambda 的提取对象字段，并拼接
         */
        List<User> userList = asList(new User("张三" , 10) , new User("李四" , 10) , new User("王五" , 13));
        String result = userList.stream().map(User::getUsername).collect(Collectors.joining(",","[","]"));
        System.out.println("对象拼接   " + result);

        // Lambda groupBy
        Stream<User> userStream = userList.stream();
        Map<Integer , List<String>> integerStringMap = userStream.collect(Collectors.groupingBy(user -> user.getAge() , Collectors.mapping(User::getUsername , toList())));
        System.out.println("Lambda 的对象操作，Lambda Group by " + integerStringMap.toString());

        String result2 = userList.stream().map(User::getUsername)
                                            .reduce(new StringJoiner(",1","[","]"),
                                                    StringJoiner::add,
                                                    StringJoiner::merge).toString();

        System.out.println(" 使用StringJoiner 对对象进行拼接 " + result2);
    }

    static class User {
        private String username;
        private int age;

        public User(){}

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    }

}
