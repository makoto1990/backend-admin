package com.backend.buyerEnd.service;

import com.backend.model.GoodsEntity;
import com.backend.buyerEnd.dao.*;

import java.util.List;

public class GoodsService {
    private GoodsDao goodsDao;
    public void setGoodsDao(GoodsDao goodsDao){this.goodsDao=goodsDao;}

    public List<GoodsEntity> loadAllGoods() {
        return this.goodsDao.listGoods();
    }
}  