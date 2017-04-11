package com.backend.adminEnd.dao;
import java.util.List;
import com.backend.adminEnd.model.OrderEntity;

/**
 * Created by kevin on 2017/4/11.
 */
public interface OrderDaoImpl {
    public void removeOrder(String orderId);
    public List<OrderEntity> listOrder();
    public OrderEntity getOrderById(String orderId);
}
