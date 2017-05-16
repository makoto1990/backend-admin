package com.backend.buyerEnd.service;

import com.backend.model.*;
import com.backend.buyerEnd.dao.*;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kevin on 2017/5/17.
 */
public class CartService {
    private CartDao cartDao;
    public void setCartDao(CartDao cartDao){
        this.cartDao=cartDao;
    }
    private Map<String, Integer> cart = new HashMap<String, Integer>();

    public void setCart(Map<String,Integer> cart){
        this.cart = cart;
    }

    public Map<String,Integer> getCart(){
        return this.cart;
    }

    public void addGoods(String goodsId, int num) {
        if (this.cart.containsKey(goodsId))
            this.cart.put(goodsId, this.cart.get(goodsId) + num);
        else
            this.cart.put(goodsId, num);
    }

    public double getCost(GoodsEntity goods) {
        return this.cart.get(goods.getGoodsId()) * goods.getGoodsPrice();
    }

    public void initCart(String userId){
        for(CartEntity cartEntity : this.cartDao.findCartbyUserID(userId)){
            this.cart.put(cartEntity.getGoodsId(),cartEntity.getCount());
        }
    }

}
