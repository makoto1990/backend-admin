package com.backend.sellerEnd;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class GoodsControServlet
 */
public class GoodsControServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   // 上传文件存储目录
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		System.out.println("接收到请求：Goods");
		String value=request.getParameter("value");
		String sellerName=request.getParameter("sellerName");
		//session.setAttribute("sellerName", sellerName);
		System.out.println(sellerName);
		ArrayList<Goods> goodslist=new ArrayList<Goods>();
		if(value.equals("release"))
	{ 
	    goodslist=releaseOfGoods(sellerName);
		Goods a=new Goods();
		for(int j=0;j<goodslist.size();j++){
			a=(Goods)goodslist.get(j);
			System.out.println(a.getGoodsName()+" "+a.getGoodsPrice()+" "+a.getSourceArea()+" "+a.getPicture());
		}
		session.setAttribute("goodslist", goodslist);
		response.sendRedirect(request.getContextPath()+"/sale/saleReleaseOfGoods.jsp");
	}
		else if(value.equals("searchgoods"))
		{ 
			String type=request.getParameter("goodstype");
			type= new String(type.getBytes("iso-8859-1"),"utf-8"); 
			String name=request.getParameter("name");
			name= new String(name.getBytes("iso-8859-1"),"utf-8"); 
			if(type.equals("全部")){
				goodslist=releaseOfGoods(name);
			}
			else goodslist=searchGoods(name,type);
			Goods a=new Goods();
			for(int j=0;j<goodslist.size();j++){
				a=(Goods)goodslist.get(j);
				System.out.println(a.getGoodsName()+" "+a.getGoodsPrice()+" "+a.getSourceArea()+" "+a.getPicture());
			}
			session.setAttribute("goodslist", goodslist);
			response.sendRedirect(request.getContextPath()+"/sale/saleReleaseOfGoods.jsp");
		}
		else if(value.equals("edit")){
			//System.out.println("goods edit:");
			String goodsID=request.getParameter("goodsID");
			Goods goods=new Goods();
			goods=goodsDetails(goodsID);
			//System.out.println(goods.getGoodsName()+" "+goods.getGoodsPrice()+" "+goods.getSourceArea()+" "+goods.getPicture());
			session.setAttribute("goods", goods);
			response.sendRedirect(request.getContextPath()+"/sale/saleEditGoods.jsp");
		}
		else if(value.equals("saveedit")){
			String[] name={"goodsID","goodsName","goodsCount","goodsPrice","storeWay","sourceArea","goodsType","leastAmount","largeAmount","largePrice","goodsSize","goodsIntro"};
			String[] values=new String[12];
			values[0]=request.getParameter("goodsID");
			values[1]=request.getParameter("name");
			values[1]= new String(values[1].getBytes("iso-8859-1"),"utf-8");  
			values[2]=request.getParameter("count");
			values[3]=request.getParameter("price");
			values[4]=request.getParameter("storeWay");
			values[4]= new String(values[4].getBytes("iso-8859-1"),"utf-8"); 
			values[5]=request.getParameter("sourceArea");
			values[5]= new String(values[5].getBytes("iso-8859-1"),"utf-8"); 
			values[6]=request.getParameter("type");
			values[6]= new String(values[6].getBytes("iso-8859-1"),"utf-8"); 
			values[7]=request.getParameter("leastAmount");
			values[8]=request.getParameter("largeAmount");
			values[9]=request.getParameter("largePrice");
			values[10]=request.getParameter("goodsSize");
			values[11]=request.getParameter("goodsIntro");
			values[11]= new String(values[11].getBytes("iso-8859-1"),"utf-8"); 
			saveEdit(name,values);
		    
			Goods goods=new Goods();
			goods=goodsDetails(values[0]);
			//System.out.println(goods.getGoodsName()+" "+goods.getGoodsPrice()+" "+goods.getSourceArea()+" "+goods.getPicture());
			session.setAttribute("goods", goods);
			response.sendRedirect(request.getContextPath()+"/sale/saleEditGoods.jsp");
		}
		else if(value.equals("delete")){
			String goodsID=request.getParameter("goodsID");
			
			deleteGoods(goodsID);
			goodslist=releaseOfGoods(sellerName);
			session.setAttribute("goodslist", goodslist);
			response.sendRedirect(request.getContextPath()+"/sale/saleReleaseOfGoods.jsp");
		}
		else if(value.equals("add")){
			String[] values=new String[14];
			values[0]=request.getParameter("addGoodsID");
			values[1]=request.getParameter("addGoodsName");
			values[1]= new String(values[1].getBytes("iso-8859-1"),"utf-8");  
			values[2]=request.getParameter("addGoodsCount");
			values[3]=request.getParameter("addGoodsPrice");
			values[4]=request.getParameter("addStoreWay");
			values[4]= new String(values[4].getBytes("iso-8859-1"),"utf-8");  
			values[5]=request.getParameter("addSourceArea");
			values[5]= new String(values[5].getBytes("iso-8859-1"),"utf-8");  
			
			Date dt=new Date();
		    values[6]=String.valueOf(dt);
			String sellername=request.getParameter("sellerName");
			System.out.println(sellername);
			values[7]=sellerID(sellername);
			
			values[8]=request.getParameter("addGoodsType");
			values[8]= new String(values[8].getBytes("iso-8859-1"),"utf-8");  
			values[9]=request.getParameter("addLeastAmount");
			values[10]=request.getParameter("addLargeAmount");
			values[11]=request.getParameter("addLargePrice");
			values[12]=request.getParameter("addGoodsSize");
			values[13]=request.getParameter("addGoodsIntro");
			values[13]= new String(values[13].getBytes("iso-8859-1"),"utf-8");  
			addGoods(values);
			session.setAttribute("addgoodsid",values[0] );
			response.sendRedirect(request.getContextPath()+"/sale/saleAddGoodsPic.jsp");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
