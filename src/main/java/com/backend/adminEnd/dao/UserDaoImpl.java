package com.backend.adminEnd.dao;

import com.backend.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by lk on 4/24/17.
 */
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addUser(UserEntity user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
    }

    @Override
    public void updateUser(UserEntity user) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<UserEntity> listUser() {
        Session session = this.sessionFactory.openSession();
        return  session.createQuery("from UserEntity").list();
    }

    @Override
    public UserEntity getUserById(String userId) {
        Session session = this.sessionFactory.openSession();
        return (UserEntity) session.load(UserEntity.class, userId);
    }

    @Override
    public void removeUser(String userId) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        UserEntity u = (UserEntity) session.load(UserEntity.class, userId);
        if (u != null) {
            session.delete(u);
        }
        transaction.commit();
    }
}
