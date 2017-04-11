package com.backend.adminEnd.dao;

import java.util.List;

import com.backend.adminEnd.model.CompositionEntity;
/**
 * Created by kevin on 2017/4/11.
 */
public interface CompositionDaoImpl {
    public List<CompositionEntity> listComposition();
    public CompositionEntity getCompositionByOrderGoodsId(String orderGoodsId);
    public List<CompositionEntity> getCompositionBySellerId(String sellerId);
    public void removeComposition(String orderGoodsId);
}
