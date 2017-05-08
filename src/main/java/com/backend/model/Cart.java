package com.backend.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    public Map<GoodsEntity, Integer> cart = new HashMap();

    public void addGoods(GoodsEntity goods, int num) {
        if (cart.containsKey(goods))
            cart.put(goods, cart.get(goods) + num);
        else
            cart.put(goods, num);
    }

    public void removeGoods(GoodsEntity goods) {
        if (cart.containsKey(goods))
            cart.remove(goods);
    }

    public void reduceGoods(GoodsEntity goods) {
        if (cart.containsKey(goods))
            if (cart.get(goods) > 0)
                cart.put(goods, cart.get(goods) - 1);
    }

    public void increaseGoods(GoodsEntity goods) {
        if (cart.containsKey(goods))
            cart.put(goods, cart.get(goods) + 1);
    }

    public double getTotalCost() {
        double sum = 0;
        for (GoodsEntity goods : cart.keySet()) {
            sum += cart.get(goods) * goods.getGoodsPrice();
        }
        return sum;
    }

    public double getCost(GoodsEntity goods) {
        return cart.get(goods) * goods.getGoodsPrice();
    }
}
