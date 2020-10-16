package com.zero.juc.c_021_02_AQS;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @ClassName Sync
 * @Description TODO
 * @Author 张春海
 * @Date 2020/10/12 23:40
 * @Version 1.0
 */
public class Sync extends AbstractQueuedSynchronizer {

    @Override
    protected boolean tryAcquire(int arg) {
        if ( compareAndSetState(0,1)) {
            setExclusiveOwnerThread(Thread.currentThread());
            return true;
        }
        return false;
    }

    @Override
    protected boolean tryRelease(int arg) {
        setExclusiveOwnerThread(null);
        setState(0);
        return true;
    }

    @Override
    protected boolean isHeldExclusively() {
        return getState() == 1;
    }
}
