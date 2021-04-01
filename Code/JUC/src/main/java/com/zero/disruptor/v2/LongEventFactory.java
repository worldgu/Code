package com.zero.disruptor.v2;

import com.lmax.disruptor.EventFactory;

/**
 * @ClassName LongEventFactory
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 23:16
 * @Version 1.0
 */
public class LongEventFactory implements EventFactory<LongEvent> {

    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
