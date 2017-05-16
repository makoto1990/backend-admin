package com.backend.defaultEnd.service;

import com.backend.defaultEnd.dao.Dao;
import com.backend.model.UserEntity;

import javax.transaction.Transactional;
import java.util.Map;

/**
 * Servlet implementation class Login
 */
public class LoginService {
    private Dao dao;


    public void setDao(Dao dao){
        this.dao = dao;
    }



    @Transactional
    public UserEntity findUser(String userName){
        return this.dao.getUserByUsername(userName);
    }


    @Transactional
    public boolean checkPassword(String username,String password){
        if(findUser(username).getPassword()==password){
            return true;
        }else{
            return false;
        }
    }


}
