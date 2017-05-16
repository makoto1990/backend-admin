package com.backend.defaultEnd.dao;

import com.backend.model.CartEntity;
import com.backend.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.SQLQuery;
import org.hibernate.type.StandardBasicTypes;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public UserEntity getUserByUsername(String userName) {
        Session session = this.sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = builder.createQuery(UserEntity.class);
        Root<UserEntity> root = criteria.from(UserEntity.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("userName"),userName));
        UserEntity result = session.createQuery(criteria).getSingleResult();
        session.close();
        return result;
    }



    public int getTopID(){
        int n=1;
        Session session = this.sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery("select top 1 userID from [User] order by userID desc");
        query.addScalar("userID", StandardBasicTypes.STRING);
        for (Object item : query.list()) {
            n = Integer.parseInt(((String)item).substring(8, ((String)item).length()).trim());
        }
        return n;
    }

    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
    }
}
