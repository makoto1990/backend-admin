package com.backend.buyerEnd.service;

import com.backend.buyerEnd.dao.GoodsDao;
import com.backend.model.GoodsEntity;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


public class SearchService {
    private GoodsDao goodsDao;
    public void setGoodsDao(GoodsDao goodsDao){this.goodsDao=goodsDao;}

    public ArrayList<GoodsEntity> loadAllGoods(String s){
        return this.goodsDao.loadAllGoods(s);
    }
}
