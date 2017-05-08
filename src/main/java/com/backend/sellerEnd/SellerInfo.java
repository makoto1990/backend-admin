package com.backend.sellerEnd;

import com.demo.supermarket.Dao;

import java.sql.*;
import java.text.SimpleDateFormat;

public class SellerInfo {

	public String[] SellerInfo(String sellerName){
		System.out.println(sellerName);
		String[] sellerInfo=new String[13];
		SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
	    String sqlstr="use onlineMarket select sellerID,a.registerDate,realName,IDnumber,Phone,Postcode,Province,City,District,Street,Address,sellerIntro  from Seller a,[User] b where a.userID=b.userID AND b.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){
				sellerInfo[0]=rs.getString("sellerID");
				sellerInfo[1]=sdf.format(rs.getDate("registerDate"));
				sellerInfo[2]=sellerName;
				sellerInfo[3]=rs.getString("realName");
				sellerInfo[4]=rs.getString("IDnumber");
				sellerInfo[5]=rs.getString("Phone");
				sellerInfo[6]=rs.getString("Postcode");
				sellerInfo[7]=rs.getString("Province");
				sellerInfo[8]=rs.getString("City");
				sellerInfo[9]=rs.getString("District");
				sellerInfo[10]=rs.getString("Street");
				sellerInfo[11]=rs.getString("Address");
				sellerInfo[12]=rs.getString("sellerIntro");
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		for(int i=0;i<sellerInfo.length;i++)System.out.println(sellerInfo[i]);
		return sellerInfo;
	}
}
