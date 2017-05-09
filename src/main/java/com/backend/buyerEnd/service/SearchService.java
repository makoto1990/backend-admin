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

import javax.transaction.Transactional;
import java.util.ArrayList;


public class SearchService {
    public SearchService(){
        super();
    }

    private GoodsDao goodsDao;
    private SearchDao searchDao;

    @Transactional
    public ArrayList<String> getAllType(){
        return this.searchDao.getAllType();
    }

    @Transactional
    public ArrayList<GoodsEntity> loadAllGoods(){
        return this.searchDao.loadAllGoods();
    }

    @Transactional
    public int getSize(){
        return this.searchDao.getSize();
    }

    @Transactional
    public String getPicture(int index){
        return this.searchDao.getPicture(index);
    }

    @Transactional
    public String getGoodsName(int index){
        return this.searchDao.getGoodsName(index);
    }

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao=goodsDao;
    }

    public void setSearchDao(SearchDao searchDao){
        this.searchDao=searchDao;
    }

    @Transactional
    public ArrayList<GoodsEntity> loadAllGoods(String s){
        return this.goodsDao.loadAllGoods(s);
    }
}
