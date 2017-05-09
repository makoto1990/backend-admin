package com.backend.sellerEnd.dao;


import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * Created by kevin on 2017/5/8.
 */
public class SellerDao {


    public void saveEdit(String[] name,String[] values){
        Connection conn;
        PreparedStatement pstmt;
        ResultSet rs;
        String sqlstr;
        for(int i=1;i<name.length-1;i++)
        {
            if(!(values[i].equals(""))&&!(values[i].equals(null)))
            {
                sqlstr="use onlineMarket update [User] set "+name[i]+"='"+values[i]+"' where userName='"+values[0]+"'";
                try{
                    conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
                    pstmt= conn.prepareStatement(sqlstr);
                    rs=pstmt.executeQuery();
                    while(rs.next()){
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
        if(!(values[8].equals(""))&&!(values[8].equals(null)))
        {
            sqlstr="use onlineMarket update [Seller] set sellerIntro='"+values[8]+"' where sellerID in (select sellerID from [User] a,[Seller]b where a.userID=b.userID AND a.userName='"+values[0]+"')";

            try{
                conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
                pstmt= conn.prepareStatement(sqlstr);
                rs=pstmt.executeQuery();
                while(rs.next()){
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

    }

    public String[] SellerInfo(String sellerName) {
        System.out.println(sellerName);
        String[] sellerInfo = new String[13];
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sqlstr = "use onlineMarket select sellerID,a.registerDate,realName,IDnumber,Phone,Postcode,Province,City,District,Street,Address,sellerIntro  from Seller a,[User] b where a.userID=b.userID AND b.userName='" + sellerName + "' ";
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122\\MSSQLSERVER:1433;databaseName=onlineMarket", "sa", "ECUSTJ143@software");
            pstmt = conn.prepareStatement(sqlstr);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                sellerInfo[0] = rs.getString("sellerID");
                sellerInfo[1] = sdf.format(rs.getDate("registerDate"));
                sellerInfo[2] = sellerName;
                sellerInfo[3] = rs.getString("realName");
                sellerInfo[4] = rs.getString("IDnumber");
                sellerInfo[5] = rs.getString("Phone");
                sellerInfo[6] = rs.getString("Postcode");
                sellerInfo[7] = rs.getString("Province");
                sellerInfo[8] = rs.getString("City");
                sellerInfo[9] = rs.getString("District");
                sellerInfo[10] = rs.getString("Street");
                sellerInfo[11] = rs.getString("Address");
                sellerInfo[12] = rs.getString("sellerIntro");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < sellerInfo.length; i++) System.out.println(sellerInfo[i]);
        return sellerInfo;
    }

}
