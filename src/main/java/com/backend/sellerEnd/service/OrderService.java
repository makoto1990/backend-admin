package com.backend.sellerEnd.service;

import com.backend.sellerEnd.dao.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class OrderService
 */

public class OrderService{

    private OrderDao orderDao;
    public void setOrderDao(OrderDao orderDao){
        this.orderDao=orderDao;
    }

    public void updateOrderStatus(String contro,String id){
        this.orderDao.updateOrderStatus(contro,id);
    }

}
