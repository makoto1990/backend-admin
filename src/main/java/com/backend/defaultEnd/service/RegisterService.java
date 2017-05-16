package com.backend.defaultEnd.service;

import com.backend.defaultEnd.dao.Dao;
import com.backend.model.UserEntity;

import javax.transaction.Transactional;
import java.sql.Timestamp;
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
        n = this.dao.getTopID();
        n++;
        String userID = dateNowStr;
        if(Integer.toString(n).length()==1)
            userID+="000";
        else if(Integer.toString(n).length()==2)
            userID+="00";
        else if(Integer.toString(n).length()==3)
            userID+="0";
        else userID+="";
        userID += n;
        user.setUserId(userID);
        user.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        try{
            addUser(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
