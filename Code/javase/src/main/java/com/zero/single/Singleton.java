package com.zero.single;

/**
 *@ClassName Singlryon_01
 *@Description TODO
 *@Author 张春海
 *@Date 2020/6/12 18:24 
 *@Version 1.0
 *
 *
 * */
public class Singleton {

    /**
     * @Author Zero
     * @Date 18:30 2020/6/12
     *
     * 饿汉式的单例模式，在类加载时创建到单例实例  而不是等到第一次请求实例时创建
     * 1. 私有 无参的构造方法Singleton() , 限制外部创建实例
     * 2. 司有的静态属性 instance
     * 3.  共有静态方法 getInstance();
     **/
    private static Singleton instance = new Singleton();

    private Singleton(){}
//
//    public static Singleton getInstance(){
//        return instance;
//    }


     /**
      * @Author Zero
      * @Date 18:30 2020/6/12
      * 懒汉式的单例模式，类加载时不创建单例实例，在第一次请求实例的时候创建
      **/
//     public static Singleton getInstance(){
//         if (instance == null) {  // 只创建一次
//             instance = new Singleton();
//         }
//         return instance;
//     }

    /**
     * @Author Zero
     * @Description
     * 多线程情况下 懒汉式的单例模式 ，避免创建多个对象
     * 需要使用synchronized 关键子  与  两次的非null 判断
     *
     **/

    public static Singleton getInstance() {
        if ( instance == null) {                //  避免每次加锁，只有第一次没有创建对象时才加锁
            synchronized (Singleton.class) {    //  加锁，只允许一个线程进入
                if(instance == null){           //只创建一次对象
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

}
