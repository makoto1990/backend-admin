package com.backend.buyerEnd.dao;

import com.backend.model.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevin on 2017/5/17.
 */
public class CartDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public ArrayList<CartEntity> findCartbyUserID(String userId) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<CartEntity> criteria = builder.createQuery(CartEntity.class);
        Root<CartEntity> root = criteria.from(CartEntity.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("userId"),userId));
        ArrayList<CartEntity> cartlist = (ArrayList<CartEntity>) session.createQuery(criteria).list();
        return cartlist;
    }

}
