package com.backend.sellerEnd;

import com.demo.supermarket.Composition;
import com.demo.supermarket.Dao;
import com.demo.supermarket.Goods;
import com.demo.supermarket.Order;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class OrderSearch {
	String s;
	ArrayList list=new ArrayList();

	public ArrayList SearchAllOrder(String sellerName){ //全部订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");  
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
	
	public ArrayList SearchWaitPayOrder(String sellerName){ //等待买家付款的订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待买家付款' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
	public ArrayList SearchWaitConfirmOrder(String sellerName){ //等待卖家确认的订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待卖家确认' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
	
	public ArrayList SearchWaitSendOrder(String sellerName){ //等待卖家发货的订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='等待卖家发货' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	
	
	
	public ArrayList SearchSendOrder(String sellerName){ //已发货的订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='卖家已发货' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
	public ArrayList SearchCancelOrder(String sellerName){ //等待卖家发货的订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c where orderStatus='订单已取消' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){
				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	
 
	public ArrayList SearchOrderDetails(String ID){ //订单详情
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
	    String sqlstr="use onlineMarket select * from [Order] where orderID="+ID;
	 try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setPhone(rs.getString("Phone"));
			    order.setorderStatus(rs.getString("orderStatus"));
			    order.setpayTime(sdf.format(rs.getTimestamp("payTime")));
			    order.setdeliveryTime(sdf.format(rs.getTimestamp("deliveryTime")));
			    order.setshipCost(rs.getFloat("shipCost"));
			    order.setconfirmTime(sdf.format(rs.getTimestamp("confirmTime")));
			    order.setPostcode(rs.getString("Postcode"));
			    order.setProvince(rs.getString("Province"));
			    order.setCity(rs.getString("City"));
			    order.setDistrict(rs.getString("District"));
			    order.setStreet(rs.getString("Street"));
			    order.setAddress(rs.getString("Address"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime"))); 
			    order.setuserID(rs.getString("userID"));
			    order.setsellerID(rs.getString("sellerID"));
			    
			    //商品信息
			    
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		return list;
		
	}
	

	public ArrayList SearchAOrder(String value,String searchvalue,String sellerName){ //查询订单
		Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlstr=null;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E"); 
		if(value=="date"){
		    sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order]a,Seller b,[User] c WHERE Convert(varchar,createTime,120) LIKE '%"+searchvalue+"%' AND a.sellerID=b.sellerID AND b.userID=c.userID AND c.userName='"+sellerName+"' ";
		}
		if( sqlstr!=null){
	    try{
		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
			pstmt= conn.prepareStatement(sqlstr);
			rs=pstmt.executeQuery();
			while(rs.next()){

				Order order=new Order();
			    order.setorderID(rs.getString("orderID"));
			    order.setreceiverName(rs.getString("receiverName"));
			    order.setcreatTime(sdf.format(rs.getTimestamp("creatTime")));
			    order.setorderStatus(rs.getString("orderStatus"));
			    list.add(order);
			}

		}catch (SQLException e){
			e.printStackTrace();
		}
	    return list;
		}
		
		else return null;
		
	}
	
	
	

 

public  ArrayList SearchOrderGood(String id){ //查询订单中包含的商品
	//ArrayList list=new ArrayList();
	String ID=id.trim();
	Dao dao=new Dao();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sqlstr;
    sqlstr="use onlineMarket select b.goodsID,goodsName,goodsType,goodsPrice,goodsAmount from Composition a,Goods b where a.goodsID=b.GoodsID AND a.order_goodsID like '"+ID+"%'";
    try{
	 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
		pstmt= conn.prepareStatement(sqlstr);
		rs=pstmt.executeQuery();
		while(rs.next()){
            
			Goods good=new Goods();
			Composition compo=new Composition();
		    good.setgoodsID(rs.getString("goodsID"));
		    good.setgoodsName(rs.getString("goodsName"));
		    good.setgoodsType(rs.getString("goodsType"));
		    good.setgoodsPrice(rs.getFloat("goodsPrice"));
		    compo.setgoodsAmount(rs.getFloat("goodsAmount"));
		    list.add(good);
		    list.add(compo);
		}

	}catch (SQLException e){
		e.printStackTrace();
	}
   
    
    return list;
	}
	
	
}


    
