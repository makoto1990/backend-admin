package com.backend.buyerEnd.dao;

import com.backend.model.GoodsEntity;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.type.StandardBasicTypes;

import java.util.ArrayList;
import java.util.List;

public class GoodsDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    @SuppressWarnings("unchecked")
    public List<GoodsEntity> listGoods(){
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from GoodsEntity").list();
    }

    public GoodsEntity getGoodsByGoodsId(String goodsId){
        Session session = this.sessionFactory.openSession();
        return (GoodsEntity) session.load(GoodsEntity.class, goodsId);
    }

    private ArrayList<GoodsEntity> allGoods = new ArrayList<GoodsEntity>();
    private ArrayList<String> sellerName = new ArrayList<String>();

    public ArrayList<GoodsEntity> loadAllGoods(String s) {
        //��ȡ�����ļ�
        allGoods.clear();
        sellerName.clear();
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            //��������
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select * from [onlineMarket].[dbo].[Goods] where goodsType like '%" + s + "%' or goodsName like '%" + s + "%'");
            query.addEntity(GoodsEntity.class);

            for (Object item : query.list()) {
                GoodsEntity goods = (GoodsEntity) item;
                allGoods.add(goods);
            }

            //�ύ����
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            //�ع�����
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    //�ر�session
                    session.close();
                }
            }
        }

        session = null;
        try {
            session = this.sessionFactory.openSession();
            //��������
            session.beginTransaction();

            SQLQuery query;
            for (int i = 0; i < allGoods.size(); i++) {
                GoodsEntity goods = allGoods.get(i);
                query = session.createSQLQuery("select userName as a "
                        + "from [onlineMarket].[dbo].[Seller] as b,[onlineMarket].[dbo].[User] as c"
                        + " where b.userID=c.userID and b.sellerID='" + goods.getSellerId() + "'");
                query.addScalar("a", StandardBasicTypes.STRING);
                String sell = (String) query.uniqueResult();
                sellerName.add(sell);

            }
            session.getTransaction().commit();
            //�ύ����
        } catch (Exception e) {
            e.printStackTrace();
            //�ع�����
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                if (session.isOpen()) {
                    //�ر�session
                    session.close();
                }
            }
        }
        return allGoods;
    }

    public void removeGoods(String goodsId){
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        GoodsEntity g = (GoodsEntity) session.load(GoodsEntity.class, goodsId);
        if (g != null) {
            session.delete(g);
        }
        transaction.commit();
    }
}
