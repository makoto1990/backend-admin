package com.backend.sellerEnd;

import com.backend.sellerEnd.dao.SellerDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

public class EditSellerService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private SellerDao sellerDao;
    public void setSellerDao(SellerDao sellerDao){
    	this.sellerDao=sellerDao;
	}

	public void saveEdit(String[]name,String[]value){
    	this.sellerDao.saveEdit(name,value);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("接收到编辑卖家信息请求");
		String[] name={"userName","Phone","PostCode","Province","City","District","Street","Address","sellerIntro"};
		String[] info=new String[9];
		info[0]=request.getParameter("userName");
		info[0]= new String(info[0].getBytes("iso-8859-1"),"utf-8");
		info[1]=request.getParameter("Phone");
		info[2]=request.getParameter("postCode");
		info[3]=request.getParameter("Province");
		info[3]= new String(info[3].getBytes("iso-8859-1"),"utf-8");
		info[4]=request.getParameter("City");
		info[4]= new String(info[4].getBytes("iso-8859-1"),"utf-8");
		info[5]=request.getParameter("District");
		info[5]= new String(info[5].getBytes("iso-8859-1"),"utf-8");
		info[6]=request.getParameter("Street");
		info[6]= new String(info[6].getBytes("iso-8859-1"),"utf-8");
		info[7]=request.getParameter("Address");
		info[7]= new String(info[7].getBytes("iso-8859-1"),"utf-8");
		info[8]=request.getParameter("sellerIntro");
		info[8]= new String(info[8].getBytes("iso-8859-1"),"utf-8");
		for(int i=0;i<info.length;i++){
			System.out.println(info[i]);
		}
		
		saveEdit(name,info);
		response.sendRedirect(request.getContextPath()+"/sale/saleMain.jsp");
	}


}
