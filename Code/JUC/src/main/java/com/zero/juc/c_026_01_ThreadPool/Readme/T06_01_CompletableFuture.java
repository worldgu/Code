package com.zero.juc.c_026_01_ThreadPool.Readme;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName T06_01_CompletableFuture
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 17:41
 * @Version 1.0
 */
public class T06_01_CompletableFuture {

    public static void main(String[] args) {
        long start,end;

        /*start = System.currentTimeMillis();

        priceOfTM();
        priceOfTB();
        priceOfJD();

        end = System.currentTimeMillis();
        System.out.println( "use serial method call! " + (end - start ));*/

        /*
          以上数据结果为:
                        After 70 sleep !
                        After 40 sleep !
                        After 154 sleep !
                        use serial method call! 470


                        After 289 sleep !
                        After 404 sleep !
                        After 451 sleep !
                         use serial method call! 1207
         */

        start = System.currentTimeMillis();

        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(()->priceOfTM());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(()->priceOfTB());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(()->priceOfJD());

        CompletableFuture.allOf(futureTM,futureTB,futureJD).join();

        CompletableFuture.supplyAsync(()->priceOfTM())
                .thenApply(String::valueOf)
                .thenApply(str -> "price " + str)
                .thenAccept(System.out::println);

        end = System.currentTimeMillis();
        System.out.println( " use serial method call! " + (end - start ));
        /*
                After 10 sleep !
                After 145 sleep !
                After 295 sleep !
                 use serial method call! 319
                After 212 sleep !
                price 3.0
         */

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double priceOfJD() {
        delay();
        return 1.00;
    }


    private static double priceOfTB() {
        delay();
        return 2.00;
    }

    private static double priceOfTM() {
        delay();
        return 3.00;
    }

    private static double priceOfAmazon() {
        delay();
        throw new RuntimeException("product not exist !");
    }

    private static void delay() {

        int time = new Random().nextInt(500);

        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("After %s sleep ! \n",time);

    }
}
