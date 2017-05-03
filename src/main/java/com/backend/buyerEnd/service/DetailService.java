package com.backend.buyerEnd.service;

import com.backend.model.*;
import com.backend.buyerEnd.dao.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;

public class DetailService {
    private GoodsDao goodsDao;
    public void setGoodsDao(GoodsDao goodsDao){this.goodsDao=goodsDao;}
    private SellerDao sellerDao;
    public void setSellerDao(SellerDao sellerDao){this.sellerDao=sellerDao;}

    @Transactional
    public GoodsEntity getGoodsByGoodsId(String goodsId) {
        return this.goodsDao.getGoodsByGoodsId(goodsId);
    }

    @Transactional
    public SellerEntity getSellerBySellerId(String sellerID) {
        return this.sellerDao.getSellerById(sellerID);
    }
}  