package com.zero.disruptor.v2;

import com.lmax.disruptor.EventHandler;

/**
 * @ClassName LongEventHandler
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 23:17
 * @Version 1.0
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println(event.getValue());
    }
}
