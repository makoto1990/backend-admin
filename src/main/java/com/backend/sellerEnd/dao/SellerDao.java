package com.backend.sellerEnd.dao;


import java.io.IOException;
import java.sql.*;
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

}
