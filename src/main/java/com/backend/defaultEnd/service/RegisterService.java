package com.backend.defaultEnd.service;

import com.backend.defaultEnd.dao.Dao;
import com.backend.model.UserEntity;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Servlet implementation class RegisterService
 */
public class RegisterService {
    static int n = 1;
    static String oldDay = "20170420";
    private Dao dao;

    public void setDao(Dao dao){
        this.dao = dao;
    }

    @Transactional
    public void addUser(UserEntity user){
        this.dao.addUser(user);
    }

    @Transactional
    public  boolean registerUser(UserEntity user){
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String dateNowStr = sdf.format(d);
        if (!dateNowStr.equals(oldDay)) {
            n = 1;
            oldDay = dateNowStr;
        }
        String userID = dateNowStr + n++;
        user.setUserId(userID);
        try{
            addUser(user);
        }catch (Exception e){
            if(e.toString().contains("该语句没有返回结果集"))
                return true;
        }
        return false;
    }

}
