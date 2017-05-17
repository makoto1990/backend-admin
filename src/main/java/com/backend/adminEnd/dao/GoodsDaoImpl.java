package com.backend.adminEnd.dao;

import com.backend.model.GoodsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lk on 4/24/17.
 */
public class GoodsDaoImpl implements GoodsDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<GoodsEntity> listGoods() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from GoodsEntity").list();
    }

    @Override
    public GoodsEntity getGoodsByGoodsId(String goodsId) {
        Session session = this.sessionFactory.openSession();
        return session.load(GoodsEntity.class, goodsId);
    }

    @Override
    public void removeGoods(String goodsId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        GoodsEntity g = session.load(GoodsEntity.class, goodsId);
        if (g != null) {
            session.delete(g);
        }
        transaction.commit();
    }
}
