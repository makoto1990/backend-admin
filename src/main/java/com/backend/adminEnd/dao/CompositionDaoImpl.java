package com.backend.adminEnd.dao;

import com.backend.model.CompositionEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by lk on 4/24/17.
 */
public class CompositionDaoImpl implements CompositionDao {
    private SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(CompositionDaoImpl.class);
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CompositionEntity> listComposition() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from CompositionEntity").list();
    }

    @Override
    public CompositionEntity getCompositionByOrderGoodsId(String orderGoodsId) {
        Session session = this.sessionFactory.openSession();
        return (CompositionEntity) session.load(CompositionEntity.class, orderGoodsId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<CompositionEntity> getCompositionBySellerId(String sellerId) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CompositionEntity> criteria = builder.createQuery(CompositionEntity.class);
        Root<CompositionEntity> root = criteria.from(CompositionEntity.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("sellerId"), sellerId));
        return session.createQuery(criteria).getResultList();
    }

    @Override
    public void removeComposition(String orderGoodsId) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        CompositionEntity c = (CompositionEntity) session.load(CompositionEntity.class, orderGoodsId);
        if (c != null) {
            session.delete(c);
        }
        transaction.commit();
    }
}
