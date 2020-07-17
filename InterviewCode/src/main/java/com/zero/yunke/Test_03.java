package com.zero.yunke;

/**
 *@ClassName Test_03
 *@Description TODO
 *@Author 张春海
 *@Date 2020/7/17 22:24 
 *@Version 1.0 */
public class Test_03 {


    public static void main(String[] args) {
        int i = get();
        System.out.println(i);
    }

    public static int get() {
        int i =0 ;
        try {
            String[] array = new String[0];
            String str = array[1];
//            System.out.println("1");
            return ++i;
        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("2");
            System.out.println("数组越界");
//            System.out.println("3" + i);
            return ++i;
        } catch (Exception e) {
            System.out.println("系统异常");
            return ++i;
        } finally {
//            System.out.println("4" + i);
            ++i;
            System.out.println(">>>>>" + i);
        }
    }

    /**
     *   开始前猜测答案
     *      数组越界
     *      2
     *
     *
     */

    /**
     * 实际运行结果
     *   数组越界
     *      1
     *
     * 说明:
     * catch中return与try中一样，会先执行return前的代码，然
     * 后暂时保存需要return的信息，再执行finally中的代码，
     * 最后再通过return返回之前保存的信息。
     * 所以，这里方法返回的值是try、catch中累积计算后的3，而非finally中计算后的4。
     *
     *
     */
}
