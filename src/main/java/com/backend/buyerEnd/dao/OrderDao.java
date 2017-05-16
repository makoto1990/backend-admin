package com.backend.buyerEnd.dao;

import com.backend.model.OrderEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    public List<OrderEntity> getOrderByUserID(String userId) {
        Session session = this.sessionFactory.getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<OrderEntity> criteria = builder.createQuery(OrderEntity.class);
        Root<OrderEntity> root = criteria.from(OrderEntity.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("userId"),userId));
        return session.createQuery(criteria).getResultList();
    }

    public void addOrder(OrderEntity order) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(order);
        transaction.commit();
    }
//	public void insertNewOrder(Order order){
//		Connection con = null;
//		PreparedStatement psmt = null;
//		ResultSet rs = null;
//		try{
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//		}catch(ClassNotFoundException e){
//			e.printStackTrace();
//		}
//		
//		try{
//			con = DriverManager.getConnection("jdbc:sqlserver://123.206.116.122:1433;DatabaseName=onlineMarket","sa","ECUSTJ143@software");
//			String sql = "insert into [Order](orderID,receiveName,Phone,orderStatus,payTime,deliveryTime,shipCost,"
//					+ "allPrice,confirmTime,Postcode,Province,City,District,Street,Address,creatTime,userID,sellerID)"
//					+ " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//			psmt = con.prepareStatement(sql);
//			psmt.setString(1, order.getorderID());
//			psmt.setString(2, order.getreceiverName());
//			psmt.setString(3, order.getPhone());
//			psmt.setString(4, order.getorderStatus());
//			psmt.setString(5, order.getpayTime());
//			psmt.setString(6, order.getdeliveryTime());
//			psmt.setDouble(7, order.getshipCost());
//			psmt.setDouble(8, order.getallPrice());
//			psmt.setString(9, order.getconfirmTime());
//			psmt.setString(10, order.getPostcode());
//			psmt.setString(11, order.getProvince());
//			psmt.setString(12, order.getCity());
//			psmt.setString(13, order.getDistrict());
//			psmt.setString(14, order.getStreet());
//			psmt.setString(15, order.getAddress());
//			psmt.setString(16, order.getcreatTime());
//			psmt.setString(17, order.getuserID());
//			psmt.setString(18, order.getsellerID());
//			
//			psmt.executeQuery();
//		}catch(SQLException e){
//			e.printStackTrace();
//		}finally{
//			try {
//				if(rs!=null) rs.close();
//				if(psmt!=null) psmt.close();
//				if(con!=null) con.close();	
//			}catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
