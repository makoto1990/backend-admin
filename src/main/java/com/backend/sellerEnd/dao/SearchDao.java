package com.backend.sellerEnd.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.backend.model.*;
import java.util.*;
/**
 * Created by kevin on 2017/5/8.
 */
public class SearchDao {


    public ArrayList SearchAllOrder(String sellerName) { //全部订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchWaitPayOrder(String sellerName) { //等待买家付款的订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待买家付款' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchWaitConfirmOrder(String sellerName) { //等待卖家确认的订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待卖家确认' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchWaitSendOrder(String sellerName) { //等待卖家发货的订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待卖家发货' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchSendOrder(String sellerName) { //已发货的订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='卖家已发货' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }

    public ArrayList SearchCancelOrder(String sellerName) { //等待卖家发货的订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='订单已取消' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchOrderDetails(String ID) { //订单详情
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String sqlstr = "use onlineMarket select * from [Order] where orderID=" + ID;
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setPhone(rs.getString("Phone"));
                order.setOrderStatus(rs.getString("orderStatus"));
                order.setPayTime(rs.getTimestamp("payTime"));
                order.setDeliveryTime(rs.getTimestamp("deliveryTime"));
                order.setShipCost(rs.getDouble("shipCost"));
                order.setConfirmTime(rs.getTimestamp("confirmTime"));
                order.setPostcode(rs.getString("Postcode"));
                order.setProvince(rs.getString("Province"));
                order.setCity(rs.getString("City"));
                order.setDistrict(rs.getString("District"));
                order.setStreet(rs.getString("Street"));
                order.setAddress(rs.getString("Address"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setUserId(rs.getString("userID"));
                order.setSellerId(rs.getString("sellerID"));

                //商品信息

                list.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;

    }


    public ArrayList SearchAOrder(String value, String searchvalue, String sellerName) { //查询订单
        ArrayList list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        if (value == "date") {
            sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c WHERE Convert(varchar,createTime,120) LIKE '%" + searchvalue + "%' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' ";
        }
        if (sqlstr != null) {
            try {
                conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
                pstmt = conn.prepareStatement(sqlstr);
                rs = pstmt.executeQuery();
                while (rs.next()) {

                    OrderEntity order = new OrderEntity();
                    order.setOrderId(rs.getString("orderID"));
                    order.setReceiverName(rs.getString("receiverName"));
                    order.setCreatTime(rs.getTimestamp("creatTime"));
                    order.setOrderStatus(rs.getString("orderStatus"));
                    list.add(order);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        } else return null;

    }


    public ArrayList SearchOrderGood(String id) { //查询订单中包含的商品
        ArrayList list = new ArrayList();
        //ArrayList list=new ArrayList();
        String ID = id.trim();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr;
        sqlstr = "use onlineMarket select b.goodsID,goodsName,goodsType,goodsPrice,goodsAmount from Composition a,Goods b where a.goodsID=b.GoodsID AND a.order_goodsID like '" + ID + "%'";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                GoodsEntity good = new GoodsEntity();
                CompositionEntity compo = new CompositionEntity();
                good.setGoodsId(rs.getString("goodsID"));
                good.setGoodsName(rs.getString("goodsName"));
                good.setGoodsType(rs.getString("goodsType"));
                good.setGoodsPrice(rs.getDouble("goodsPrice"));
                compo.setGoodsAmount(rs.getInt("goodsAmount"));
                list.add(good);
                list.add(compo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    public List<OrderEntity> searchOrder(String searchType,String searchValue){
        ArrayList list = new ArrayList();
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr = null;
        int i = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss E");

        if (searchType.equals("date")) {
            sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order] WHERE Convert(varchar(100),creatTime,120) LIKE '%" + searchValue + "%'";
        } else if (searchType.equals("id")) {
            sqlstr = "use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order] WHERE orderID LIKE '%" + searchValue + "%'";
        } else if (searchType.equals("name")) {
            sqlstr = "use onlineMarket select a.orderID,receiverName,creatTime,orderStatus from [Order] a,Composition b,Goods c WHERE a.orderID=b.orderID AND b.goodsID=c.goodsID AND c.goodsName like '%" + searchValue + "%'";
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                OrderEntity order = new OrderEntity();
                order.setOrderId(rs.getString("orderID"));
                order.setReceiverName(rs.getString("receiverName"));
                order.setCreatTime(rs.getTimestamp("creatTime"));
                order.setOrderStatus(rs.getString("orderStatus"));
                list.add(order);
                // list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        OrderEntity a = new OrderEntity();
        for (int j = 0; j < list.size(); j++) {
            a = (OrderEntity) list.get(j);
            System.out.println(a.getOrderId() + " " + a.getReceiverName() + " " + a.getCreatTime() + " " + a.getOrderStatus());
        }
        return list;

    }
}
