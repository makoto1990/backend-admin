package com.backend.sellerEnd.service;

import com.backend.model.*;
import com.backend.sellerEnd.dao.SearchDao;
import org.springframework.stereotype.Service;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService{

    private SearchDao searchDao;
    public void setSearchDao(SearchDao searchDao){
        this.searchDao = searchDao;
    }
    public List<OrderEntity> searchOrder(String searchType, String searchValue){
        return this.searchDao.searchOrder(searchType,searchValue);
    }
    public ArrayList SearchOrderGood(String id) {
        return this.searchDao.SearchOrderGood(id);
    }//查询订单中包含的商品
    public ArrayList SearchAOrder(String value, String searchvalue, String sellerName) { //查询订单
        return this.searchDao.SearchAOrder(value,searchvalue,sellerName);
    }
    public ArrayList SearchOrderDetails(String ID) { //订单详情
        return this.searchDao.SearchOrderDetails(ID);
    }
    public ArrayList SearchCancelOrder(String sellerName) { //等待卖家发货的订单
        return this.searchDao.SearchCancelOrder(sellerName);
    }
    public ArrayList SearchSendOrder(String sellerName) { //已发货的订单
        return this.searchDao.SearchSendOrder(sellerName);
    }
    public ArrayList SearchWaitSendOrder(String sellerName) { //等待卖家发货的订单
        return this.searchDao.SearchWaitSendOrder(sellerName);
    }
    public ArrayList SearchWaitConfirmOrder(String sellerName) { //等待卖家确认的订单
        return this.searchDao.SearchWaitConfirmOrder(sellerName);
    }
    public ArrayList SearchWaitPayOrder(String sellerName) { //等待买家付款的订单
        return this.searchDao.SearchWaitPayOrder(sellerName);
    }
    public ArrayList SearchAllOrder(String sellerName) { //全部订单
        return this.searchDao.SearchAllOrder(sellerName);
    }


}
