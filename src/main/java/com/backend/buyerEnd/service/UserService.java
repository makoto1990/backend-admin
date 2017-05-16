package com.backend.buyerEnd.service;

import com.backend.model.UserEntity;
import com.backend.buyerEnd.dao.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.List;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){this.userDao=userDao;}
    @Transactional
    public List<UserEntity> loadAllUser() {
        return this.userDao.listUser();
    }
    @Transactional
    public UserEntity getUserByUserName(String username){
        return this.userDao.getUserByUserName(username);
    }
    @Transactional
    public List<UserEntity> listUser() {
        return this.userDao.listUser();
    }
    @Transactional
    public void updateUser(UserEntity user){
        this.userDao.updateUser(user);
    }

}
