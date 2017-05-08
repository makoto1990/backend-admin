package com.backend.sellerEnd;

import com.demo.supermarket.Dao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class OrderControServlet
 */

public class OrderControServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public OrderControServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String contro=request.getParameter("contro").trim();
		String id=request.getParameter("id").trim();
		
		Dao dao=new Dao();
 		Connection conn=null;
 		PreparedStatement pstmt=null;
 		ResultSet rs=null;
 		String sqlstr=null;
		
 		if(contro.equals("0")){sqlstr="use onlineMarket update  [Order] set orderStatus='订单已取消' where orderID="+id;}
		else if(contro.equals("1")){sqlstr="use onlineMarket update  [Order] set orderStatus='等待卖家发货' where orderID="+id+" update  [Order] set confirmTime=getdate() where orderID="+id;}
		else if(contro.equals("2")){sqlstr="use onlineMarket update  [Order] set orderStatus='卖家已发货' where orderID="+id+" update  [Order] set deliveryTime=getdate() where orderID="+id;}	
 		try{
 		 conn = DriverManager.getConnection(dao.getUrl(), dao.getUsname(), dao.getPassword());
 			pstmt= conn.prepareStatement(sqlstr);
 			rs=pstmt.executeQuery();
 		
 		}catch (SQLException e){
 			e.printStackTrace();
 		}
 			
		String url="sale/saleOrderDetails.jsp?id="+id;
		response.sendRedirect(url);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
