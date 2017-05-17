package com.backend.adminEnd.dao;

import com.backend.model.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lk on 4/24/17.
 */
public class OrderDaoImpl implements OrderDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void removeOrder(String orderId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        OrderEntity o = session.load(OrderEntity.class, orderId);
        if (o != null) {
            session.delete(o);
        }
        transaction.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OrderEntity> listOrder() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from OrderEntity").list();
    }

    @Override
    public OrderEntity getOrderById(String orderId) {
        Session session = this.sessionFactory.openSession();
        return session.load(OrderEntity.class, orderId);
    }
}
