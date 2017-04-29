package com.backend.defaultEnd.dao;

import com.backend.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Dao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    public UserEntity getUserByUsername(String userName) {
        Session session = this.sessionFactory.getCurrentSession();
        return (UserEntity) session.load(UserEntity.class, userName);
    }

    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
    }
}
