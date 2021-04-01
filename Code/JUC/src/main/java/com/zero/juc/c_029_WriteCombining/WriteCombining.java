package com.zero.juc.c_029_WriteCombining;

/**
 * @ClassName WriteCombining
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 20:31
 * @Version 1.0
 */
public class WriteCombining {

    private static final int ITERATIONS = Integer.MAX_VALUE;
    private static final int ITEMS = 1 << 24;
    private static final int MASK = ITEMS - 1;

    private static final byte[] arrayA = new byte[ITEMS];
    private static final byte[] arrayB = new byte[ITEMS];
    private static final byte[] arrayC = new byte[ITEMS];
    private static final byte[] arrayD = new byte[ITEMS];
    private static final byte[] arrayE = new byte[ITEMS];
    private static final byte[] arrayF = new byte[ITEMS];

    public static void main(String[] args) {
        for (int i = 1; i <= 3 ; i++) {
            System.out.println(i + " SingleLoop duration (ns) = " + runCaseOne());
            System.out.println(i + " SplitLoop duration (ns) = " + runCaseTwo());
        }

        /*
                1 SingleLoop duration (ns) = 16052
                1 SplitLoop duration (ns) = 7803
                2 SingleLoop duration (ns) = 13075
                2 SplitLoop duration (ns) = 7879
                3 SingleLoop duration (ns) = 8866
                3 SplitLoop duration (ns) = 7474
         */
    }

    private static long runCaseOne() {
        long start = System.nanoTime();
        int i = ITERATIONS;

        while ( --i != 0) {
            int slot = i & MASK;
            byte b = (byte) i;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
        }
        return (System.nanoTime() - start) / 100_0000;
    }

    private static long runCaseTwo() {
        long start = System.nanoTime();
        int i = ITERATIONS;
        while ( --i != 0) {
            int slot = i & MASK;
            byte b = (byte) i ;
            arrayA[slot] = b;
            arrayB[slot] = b;
            arrayC[slot] = b;
        }
        i = ITERATIONS;
        while ( --i != 0) {
            int slot = i & MASK;
            byte b = (byte) i ;
            arrayD[slot] = b;
            arrayE[slot] = b;
            arrayF[slot] = b;
        }
        return (System.nanoTime() - start) / 100_0000;
    }


}
