package com.backend.buyerEnd.dao;

import com.backend.model.SellerEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lk on 4/24/17.
 */
public class SellerDao implements com.backend.adminEnd.dao.SellerDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addSeller(SellerEntity seller) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(seller);
        transaction.commit();
    }

    @Override
    public void updateSeller(SellerEntity seller) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(seller);
        transaction.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SellerEntity> listSeller() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from SellerEntity").list();
    }

    @Override
    public SellerEntity getSellerById(String sellerId) {
        Session session = this.sessionFactory.openSession();
        return (SellerEntity) session.load(SellerEntity.class, sellerId);
    }

    @Override
    public void removeSeller(String sellerId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        SellerEntity s = (SellerEntity) session.load(SellerEntity.class, sellerId);
        if (s != null) {
            session.delete(s);
        }
        transaction.commit();
    }
}
