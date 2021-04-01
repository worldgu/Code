package com.zero.lockdemo.lock;

import com.zero.lockdemo.dao.TblOrderLockDao;
import com.zero.lockdemo.entity.TblOrderLock;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @ClassName MysqlLock
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/17 15:21
 * @Version 1.0
 */
@Service
@Data
public class MysqlLock implements Lock {

    @Autowired
    TblOrderLockDao mapper;

    private ThreadLocal<TblOrderLock> orderLockThreadLocal;

    @Override
    public void lock() {
        // 1、尝试加锁
        if (tryLock()) {
            System.out.println("尝试加锁");
            return;
        }
        // 2、休眠
        try {
            Thread.sleep(10);
        } catch (InterruptedException e ) {
            e.printStackTrace();
        }
        // 3、递归在此调用
        lock();
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 非阻塞式加锁，成功，就成功，失败就失败，直接返回
     * @return
     */
    @Override
    public boolean tryLock() {
        try {
            TblOrderLock tblOrderLock = orderLockThreadLocal.get();
            mapper.insertSelective(tblOrderLock);
            System.out.println("加锁对象：" + orderLockThreadLocal.get());
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        mapper.deleteByPrimaryKey(orderLockThreadLocal.get().getOrderId());
        System.out.println("解锁对象： " + orderLockThreadLocal.get());
        orderLockThreadLocal.remove();
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
