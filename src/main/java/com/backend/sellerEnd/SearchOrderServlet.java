package com.backend.sellerEnd;

import com.demo.supermarket.Dao;
import com.demo.supermarket.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Servlet implementation class SearchOrderServlet
 */

public class SearchOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		
		String value=request.getParameter("select");
		String searchvalue=request.getParameter("input");
		searchvalue = new String(searchvalue.getBytes("iso-8859-1"),"gb2312");  
        
		
		
		System.out.println("接收到请求:name="+value+"  searchvalue="+searchvalue);
		
	    Dao dao=new Dao();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sqlstr=null;
	    ArrayList list=new ArrayList();
		int i=0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss E");   
 
		if(value.equals("date")){
		    sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order] WHERE Convert(varchar(100),creatTime,120) LIKE '%"+searchvalue+"%'";
		}
		else if(value.equals("id")){
			  sqlstr="use onlineMarket select orderID,receiverName,creatTime,orderStatus from [Order] WHERE orderID LIKE '%"+searchvalue+"%'";
		}
		else if(value.equals("name")){
			sqlstr="use onlineMarket select a.orderID,receiverName,creatTime,orderStatus from [Order] a,Composition b,Goods c WHERE a.orderID=b.orderID AND b.goodsID=c.goodsID AND c.goodsName like '%"+searchvalue+"%'";       
		}
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
			   // list.add(order);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
        Order a=new Order();
		for(int j=0;j<list.size();j++){
			a=(Order)list.get(j);
			System.out.println(a.getorderID()+" "+a.getreceiverName()+" "+a.getcreatTime()+" "+a.getorderStatus());
		}
		session.setAttribute("list", list);
		response.sendRedirect(request.getContextPath()+"/sale/saleOrderSearch.jsp");
		//request.getRequestDispatcher("/sale/searchByDate.jsp").forward(request,response); 

		
	}

}
