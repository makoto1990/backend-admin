package com.backend.sellerEnd.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.backend.model.*;
/**
 * Created by kevin on 2017/5/8.
 */
public class OrderDao {
    public void updateOrderStatus(String contro,String id){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr = null;

        if (contro.equals("0")) {
            sqlstr = "use onlineMarket update  [Order] set orderStatus='订单已取消' where orderID=" + id;
        } else if (contro.equals("1")) {
            sqlstr = "use onlineMarket update  [Order] set orderStatus='等待卖家发货' where orderID=" + id + " update  [Order] set confirmTime=getdate() where orderID=" + id;
        } else if (contro.equals("2")) {
            sqlstr = "use onlineMarket update  [Order] set orderStatus='卖家已发货' where orderID=" + id + " update  [Order] set deliveryTime=getdate() where orderID=" + id;
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
