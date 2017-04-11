package com.backend.adminEnd.dao;

import java.util.List;
import com.backend.adminEnd.model.GoodsEntity;

/**
 * Created by kevin on 2017/4/11.
 */
public interface GoodsDaoImpl {
    public void addGoods(GoodsEntity goods);
    public void updateGoods(GoodsEntity goods);
    public List<GoodsEntity> listGoods();
    public GoodsEntity getGoodsByGoodsId(String goodsId);
    public void removeGoods(String goodsId);
}
