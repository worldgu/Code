package com.zero.disruptor.v1;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 23:21
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {
//        Executor executor = Executors.newCachedThreadPool();

        LongEventFactory factory  = new LongEventFactory();

        // must be power of 2
        int ringBuferSize = 1024;

        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(factory, ringBuferSize,Executors.defaultThreadFactory());

        disruptor.handleEventsWith(new LongEventHandler());

        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();

        LongEventProducer producer = new LongEventProducer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        for (long i = 0; i < 100; i++) {
            bb.putLong(0,i);

            producer.onData(bb);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        disruptor.shutdown();
    }
}
