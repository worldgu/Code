package com.zero.lockdemo.service.impl;

import com.zero.lockdemo.dao.TblOrderDao;
import com.zero.lockdemo.entity.TblOrder;
import com.zero.lockdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName OrderServiceImpl
 * @Description TODO
 * @Author 张春海
 * @Date 2020/12/14 19:35
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private TblOrderDao mapper;

    @Override
    public boolean grab(int orderId, int driverId) {
        TblOrder order = mapper.selectByPrimaryKey(orderId);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 中间可以添加更多的业务信息，在此使用 线程睡眠进行，替代业务

        if ( order.getOrderStatus().intValue() == 0 ) {
            order.setOrderStatus(1);
            mapper.updateByPrimaryKeySelective(order);

            return true;
        }

        return false;
    }
}
