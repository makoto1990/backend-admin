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
/**
 * Created by kevin on 2017/5/8.
 */
public class SearchDao {
    private ArrayList<GoodsEntity> allGoods = new ArrayList<GoodsEntity>();
    private ArrayList<String> allType = new ArrayList<String>();

    public ArrayList<String> getAllType() {

        allType.clear();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try {
            session = factory.openSession();
            //��������
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select distinct goodsType as a from [onlineMarket].[dbo].[Goods]");

            query.addScalar("a", StandardBasicTypes.STRING);

            for (Object item : query.list()) {
                String type = (String) item;
                allType.add(type);
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
        return allType;
    }


    //public ArrayList<Goods> loadAllGoods(String s) {
    public ArrayList<GoodsEntity> loadAllGoods() {

        allGoods.clear();
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = null;
        try {
            session = factory.openSession();
            //��������
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select * from [onlineMarket].[dbo].[Goods]");
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
        return allGoods;
    }

    public int getSize() {
        return allGoods.size();
    }

    public String getGoodsName(int index) {
        GoodsEntity good = allGoods.get(index);
        return good.getGoodsName();
    }

    public String getPicture(int index) {
        GoodsEntity good = allGoods.get(index);
        return good.getSourceArea();
    }
}
