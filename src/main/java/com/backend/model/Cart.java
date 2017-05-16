package com.backend.model;

import com.backend.buyerEnd.dao.GoodsDao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<String, Integer> cart = new HashMap();

    public void addGoods(String goodsId, int num) {
        if (cart.containsKey(goodsId))
            cart.put(goodsId, cart.get(goodsId) + num);
        else
            cart.put(goodsId, num);
    }

    public double getCost(GoodsEntity goods) {
        return cart.get(goods) * goods.getGoodsPrice();
    }

    public void init(String userId) {
        ArrayList<CartEntity> cartlist = new ArrayList<CartEntity>();
        //get cartlist
        for(CartEntity cartEntity : cartlist){
            cart.put(cartEntity.getGoodsId(),cartEntity.getCount());
        }
    }
}
