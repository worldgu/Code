package com.zero.disruptor.v2;

/**
 * @ClassName LongEvent
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/16 23:15
 * @Version 1.0
 */
public class LongEvent {
    private long value;

    public long getValue(){
        return value;
    }

    public void setValue(long value ) {
        this.value = value;
    }
}
