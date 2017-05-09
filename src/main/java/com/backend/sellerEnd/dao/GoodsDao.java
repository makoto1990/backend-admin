package com.backend.sellerEnd.dao;

import com.backend.model.GoodsEntity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by kevin on 2017/5/8.
 */
public class GoodsDao {
    public String GoodsID() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Date dt = new Date();
        SimpleDateFormat matter1 = new SimpleDateFormat("yyyyMMdd");
        String date = matter1.format(dt);
        String maxGoodsID = new String("0000");
        //System.out.println(maxGoodsID);
        String sqlstr = "use onlineMarket select max(goodsID)maxGoodsID from [Goods] where goodsID like '" + date + "%' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("maxGoodsID") != null) {
                    maxGoodsID = rs.getString("maxGoodsID");
                } else {
                    maxGoodsID = date + maxGoodsID;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String s1 = maxGoodsID.substring(0, 8);
        String s2 = maxGoodsID.substring(8, 12);
        int number = Integer.parseInt(s2) + 1;
        s2 = String.valueOf(number);
        while (s2.length() < 4) {
            s2 = "0" + s2;
        }
        maxGoodsID = s1 + s2;

        return maxGoodsID;
    }

    public ArrayList<GoodsEntity> releaseOfGoods(String sellerName) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;
        ArrayList<GoodsEntity> list = new ArrayList<GoodsEntity>();
        sqlstr = "use onlineMarket select goodsID,goodsName,goodsPrice,sourceArea,Picture from [Goods]a,Seller b,[User]c  where  a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "'";


        System.out.println(sqlstr);

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                GoodsEntity goods = new GoodsEntity();
                goods.setGoodsId(rs.getString("goodsID"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsPrice(rs.getDouble("goodsPrice"));
                goods.setSourceArea((rs.getString("sourceArea")));
                goods.setPicture(rs.getString("Picture"));
                list.add(goods);
                // list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
        //session.setAttribute("list", list);
        //response.sendRedirect(request.getContextPath()+"/sale/OrderSearch.jsp");
    }

    public ArrayList<GoodsEntity> searchGoods(String sellerName, String type) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;
        ArrayList<GoodsEntity> list = new ArrayList<GoodsEntity>();
        sqlstr = "use onlineMarket select goodsID,goodsName,goodsPrice,sourceArea,Picture from [Goods]a,Seller b,[User]c  where  a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='" + sellerName + "' AND a.goodsType='" + type + "'";


        System.out.println(sqlstr);

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                GoodsEntity goods = new GoodsEntity();
                goods.setGoodsId(rs.getString("goodsID"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsPrice(rs.getDouble("goodsPrice"));
                goods.setSourceArea((rs.getString("sourceArea")));
                goods.setPicture(rs.getString("Picture"));
                list.add(goods);
                // list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
        //session.setAttribute("list", list);
        //response.sendRedirect(request.getContextPath()+"/sale/OrderSearch.jsp");
    }


    public GoodsEntity goodsDetails(String goodsID) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr = null;
        GoodsEntity goods = new GoodsEntity();
        sqlstr = "use onlineMarket select * from [Goods] where goodsID='" + goodsID + "'";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                goods.setGoodsId(rs.getString("goodsID"));
                goods.setGoodsName(rs.getString("goodsName"));
                goods.setGoodsCount(rs.getInt("goodsCount"));
                goods.setGoodsPrice(rs.getDouble("goodsPrice"));
                goods.setStoreWay(rs.getString("storeWay"));
                goods.setSourceArea((rs.getString("sourceArea")));
                goods.setGoodsType(rs.getString("goodsType"));
                goods.setLeastAmount(rs.getDouble("leastAmount"));
                goods.setLargeAmount(rs.getDouble("largeAmount"));
                goods.setLargePrice(rs.getDouble("largePrice"));
                goods.setSellerId(rs.getString("sellerID"));
                goods.setGoodsSize(rs.getString("goodsSize"));
                goods.setGoodsIntro(rs.getString("goodsIntro"));
                goods.setPicture(rs.getString("Picture"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return goods;
    }

    public void saveEdit(String[] name, String[] values) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;
        String[] values2 = new String[12];
        sqlstr = "use onlineMarket select goodsName,goodsCount,goodsPrice,storeWay,sourceArea,goodsType,leastAmount,largeAmount,largePrice,goodsSize,goodsIntro from [Goods] where goodsID='" + values[0] + "'";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                values2[1] = rs.getString("goodsName");
                values2[2] = rs.getString("goodsCount");
                values2[3] = rs.getString("goodsPrice");
                values2[4] = rs.getString("storeWay");
                values2[5] = rs.getString("sourceArea");
                values2[6] = rs.getString("goodsType");
                values2[7] = rs.getString("leastAmount");
                values2[8] = rs.getString("largeAmount");
                values2[9] = rs.getString("largePrice");
                values2[10] = rs.getString("goodsSize");
                values2[11] = rs.getString("goodsIntro");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < name.length; i++) {
            if (values[i].equals("") || values[i].equals(null)) {
                values[i] = values2[i];
            }
        }

        sqlstr = "use onlineMarket update [Goods] set goodsName='" + values[1] + "',goodsCount=" + values[2] + ",goodsPrice=" + values[3] + ",storeWay='" + values[4] + "',sourceArea='" + values[5] + "',goodsType='" + values[6] + "',leastAmount=" + values[7] + ",largeAmount=" + values[8] + ",largePrice=" + values[9] + ",goodsSize='" + values[10] + "',goodsIntro='" + values[11] + "'  where goodsID='" + values[0] + "'";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void addGoods(String[] values) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;

        sqlstr = "use onlineMarket insert into [Goods] values('" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] + "','" + values[5] + "',getdate(),'" + values[7] + "','" + values[8] + "','" + values[9] + "','" + values[10] + "','" + values[11] + "','default.jpg','" + values[12] + "','" + values[13] + "')";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteGoods(String goodsID) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;

        sqlstr = "use onlineMarket delete from Goods where goodsID='" + goodsID + "'";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public String sellerID(String sellerName) {
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;
        String sellerID = null;
        sqlstr = "use onlineMarket select sellerID from [User] a,[Seller] b where a.userID=b.userID AND a.userName='" + sellerName + "' ";

        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                sellerID = rs.getString("sellerID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sellerID;

    }


}
