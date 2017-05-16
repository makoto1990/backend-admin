package com.backend.sellerEnd.service;


import com.backend.model.GoodsEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.backend.sellerEnd.dao.*;

/**
 * Servlet implementation class GoodsService
 */
public class GoodsService extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private GoodsDao goodsDao;

    public void setGoodsDao(GoodsDao goodsDao){
        this.goodsDao=goodsDao;
    }
    // 上传文件存储目录

    public String GoodsID(){
        return this.goodsDao.GoodsID();
    }
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
 //   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    public ArrayList<GoodsEntity> getRelease(String sellerName) {
        ArrayList<GoodsEntity> goodslist = new ArrayList<GoodsEntity>();
        goodslist = this.goodsDao.releaseOfGoods(sellerName);
        GoodsEntity a = new GoodsEntity();
        for (int j = 0; j < goodslist.size(); j++) {
            a = (GoodsEntity) goodslist.get(j);
            System.out.println(a.getGoodsName() + " " + a.getGoodsPrice() + " " + a.getSourceArea() + " " + a.getPicture());
        }
        return goodslist;
    }

    public ArrayList<GoodsEntity> searchGoods(String goodsType,String sellerName) {
        ArrayList<GoodsEntity> goodslist = new ArrayList<GoodsEntity>();
        if (goodsType.equals("全部")) {
            goodslist = this.goodsDao.releaseOfGoods(sellerName);
        } else goodslist = this.goodsDao.searchGoods(sellerName, goodsType);
        GoodsEntity a = new GoodsEntity();
        for (int j = 0; j < goodslist.size(); j++) {
            a = (GoodsEntity) goodslist.get(j);
            System.out.println(a.getGoodsName() + " " + a.getGoodsPrice() + " " + a.getSourceArea() + " " + a.getPicture());
        }
        return goodslist;
    }

    public GoodsEntity editGoods(String goodsID){
        GoodsEntity goods = new GoodsEntity();
        goods = this.goodsDao.goodsDetails(goodsID);
        return goods;
    }

    public GoodsEntity saveEdit(String[]values){
        String[] name = {"goodsID", "goodsName", "goodsCount", "goodsPrice", "storeWay", "sourceArea", "goodsType", "leastAmount", "largeAmount", "largePrice", "goodsSize", "goodsIntro"};
        this.goodsDao.saveEdit(name, values);
        GoodsEntity goods = new GoodsEntity();
        goods = this.goodsDao.goodsDetails(values[0]);
        return goods;
    }

    public ArrayList<GoodsEntity> deleteGoods(String goodsID,String sellerName){
        ArrayList<GoodsEntity> goodslist = new ArrayList<GoodsEntity>();
        this.goodsDao.deleteGoods(goodsID);
        goodslist = this.goodsDao.releaseOfGoods(sellerName);
        return goodslist;
    }

    public String sellerID(String sellerName){
        return this.goodsDao.sellerID(sellerName);
    }

    public String addGoods(String[] values){
        this.goodsDao.addGoods(values);
        return values[0];
    }

}
