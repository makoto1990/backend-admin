package com.backend.sellerEnd.dao;

import com.backend.model.GoodsEntity;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Created by kevin on 2017/5/8.
 */
public class PictureDao {
    public void savePic(String goodsID, String fileName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr = null;
        sqlstr = "use onlineMarket update Goods set Picture='" + fileName + "' where goodsID='" + goodsID + "'";
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
}
