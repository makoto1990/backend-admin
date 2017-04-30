package com.backend.defaultEnd.dao;

import com.backend.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
        return session.createQuery(criteria).getSingleResult();
    }

    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.openSession();
        session.persist(user);
    }
}
