package com.backend.buyerEnd.service;

import com.backend.buyerEnd.dao.GoodsDao;
import com.backend.buyerEnd.dao.SearchDao;
import com.backend.model.GoodsEntity;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import java.util.ArrayList;


public class SearchService {
    private GoodsDao goodsDao;
    private SearchDao searchDao;

    public ArrayList<String> getAllType(){
        return this.searchDao.getAllType();
    }

    public ArrayList<GoodsEntity> loadAllGoods(){
        return this.searchDao.loadAllGoods();
    }

    public int getSize(){
        return this.searchDao.getSize();
    }

    public String getPicture(int index){
        return this.searchDao.getPicture(index);
    }

    public String getGoodsName(int index){
        return this.searchDao.getGoodsName(index);
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao=goodsDao;
    }

    public void setSearchDao(SearchDao searchDao){
        this.searchDao=searchDao;
    }

    public ArrayList<GoodsEntity> loadAllGoods(String s){
        return this.goodsDao.loadAllGoods(s);
    }
}
