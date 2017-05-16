package com.backend.buyerEnd.service;
import com.backend.model.*;
import com.backend.buyerEnd.dao.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kevin on 2017/5/16.
 */
public class OrderService {
    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao){
        this.orderDao=orderDao;
    }
    @Transactional
    public List<OrderEntity> getOrderByUserID(String userId) {
        return this.orderDao.getOrderByUserID(userId);
    }
    @Transactional
    public void addOrder(OrderEntity order) {
        this.orderDao.addOrder(order);
    }
}
