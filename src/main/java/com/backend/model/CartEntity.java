package com.backend.model;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * Created by kevin on 2017/5/10.
 */
@Entity
@Table(name = "[Cart]", schema = "dbo", catalog = "onlineMarket")
public class CartEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userId;
    private String goodsId;
    private Integer count;

    @Id
    @Column(name = "userID", nullable = false, length = 12)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "goodsID", nullable = true, length = 12)
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name = "count", nullable = true)
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartEntity that = (CartEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (goodsId != null ? goodsId.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        return result;
    }
}
