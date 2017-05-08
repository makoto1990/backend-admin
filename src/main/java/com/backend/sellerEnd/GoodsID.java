package com.backend.sellerEnd;

import com.demo.supermarket.Dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GoodsID {
//
//	public static void main(String[] args){
//		GoodsID();
//	}

	public String GoodsID(){
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Date dt=new Date();
	    SimpleDateFormat matter1=new SimpleDateFormat("yyyyMMdd");
	    String date=matter1.format(dt);
	    String maxGoodsID=new String("0000");
	    //System.out.println(maxGoodsID);
	    String sqlstr="use onlineMarket select max(goodsID)maxGoodsID from [Goods] where goodsID like '"+date+"%' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("maxGoodsID")!=null)
				{
				  maxGoodsID=rs.getString("maxGoodsID");
				}
				else {
					 maxGoodsID=date+maxGoodsID;
			}
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	 String s1=maxGoodsID.substring(0,8);
	 String s2=maxGoodsID.substring(8,12);
	// System.out.println(s1);
	// System.out.println(s2); 
	 int number=Integer.parseInt(s2)+1;
	 s2=String.valueOf(number);
	 while(s2.length()<4){
		 s2="0"+s2;
	 }
	 maxGoodsID=s1+s2;
	 
	 
	// System.out.println(maxGoodsID);
	 
	return maxGoodsID;
	}
}
