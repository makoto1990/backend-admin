package com.backend.buyerEnd.service;

import com.backend.model.UserEntity;
import com.backend.buyerEnd.dao.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class UserService {
    private UserDao userDao;
    public void setUserDao(UserDao userDao){this.userDao=userDao;}

    public List<UserEntity> loadAllUser() {
        return this.userDao.listUser();
    }
}
