package com.backend.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by kevin on 2017/4/25.
 */
@Entity
@Table(name = "[Goods]", schema = "dbo", catalog = "onlineMarket")
public class GoodsEntity {
    private String goodsId;
    private String goodsName;
    private Integer goodsCount;
    private Double goodsPrice;
    private String storeWay;
    private String sourceArea;
    private Timestamp setDate;
    private String sellerId;
    private String goodsType;
    private Double leastAmount;
    private Double largeAmount;
    private Double largePrice;
    private String picture;
    private String goodsSize;
    private String goodsIntro;

    @Id
    @Column(name = "goodsID", nullable = false, length = 12)
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    @Basic
    @Column(name= "goodsSize",nullable = true,length = 50)
    public String getGoodsSize() {return goodsSize;}

    public void setGoodsSize(String goodsSize){this.goodsSize=goodsSize;}

    @Basic
    @Column(name = "goodsIntro",nullable = true,length = 500)
    public String getGoodsIntro(){return goodsIntro;}

    public void setGoodsIntro(String goodsIntro){this.goodsIntro=goodsIntro;}

    @Basic
    @Column(name = "goodsName", nullable = true, length = 20)
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Basic
    @Column(name = "goodsCount", nullable = true, precision = 0)
    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Basic
    @Column(name = "goodsPrice", nullable = true, precision = 0)
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Basic
    @Column(name = "storeWay", nullable = true, length = 20)
    public String getStoreWay() {
        return storeWay;
    }

    public void setStoreWay(String storeWay) {
        this.storeWay = storeWay;
    }

    @Basic
    @Column(name = "sourceArea", nullable = true, length = 20)
    public String getSourceArea() {
        return sourceArea;
    }

    public void setSourceArea(String sourceArea) {
        this.sourceArea = sourceArea;
    }

    @Basic
    @Column(name = "setDate", nullable = true)
    public Timestamp getSetDate() {
        return setDate;
    }

    public void setSetDate(Timestamp setDate) {
        this.setDate = setDate;
    }

    @Basic
    @Column(name = "sellerID", nullable = true, length = 12)
    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    @Basic
    @Column(name = "goodsType", nullable = true, length = 20)
    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    @Basic
    @Column(name = "leastAmount", nullable = true, precision = 0)
    public Double getLeastAmount() {
        return leastAmount;
    }

    public void setLeastAmount(Double leastAmount) {
        this.leastAmount = leastAmount;
    }

    @Basic
    @Column(name = "largeAmount", nullable = true, precision = 0)
    public Double getLargeAmount() {
        return largeAmount;
    }

    public void setLargeAmount(Double largeAmount) {
        this.largeAmount = largeAmount;
    }

    @Basic
    @Column(name = "largePrice", nullable = true, precision = 0)
    public Double getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(Double largePrice) {
        this.largePrice = largePrice;
    }

    @Basic
    @Column(name = "Picture", nullable = true, length = 500)
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (goodsId != null ? !goodsId.equals(that.goodsId) : that.goodsId != null) return false;
        if (goodsName != null ? !goodsName.equals(that.goodsName) : that.goodsName != null) return false;
        if (goodsCount != null ? !goodsCount.equals(that.goodsCount) : that.goodsCount != null) return false;
        if (goodsSize != null ? !goodsSize.equals(that.goodsSize) : that.goodsSize != null) return false;
        if (goodsIntro != null ? !goodsIntro.equals(that.goodsIntro) : that.goodsIntro != null) return false;
        if (goodsPrice != null ? !goodsPrice.equals(that.goodsPrice) : that.goodsPrice != null) return false;
        if (storeWay != null ? !storeWay.equals(that.storeWay) : that.storeWay != null) return false;
        if (sourceArea != null ? !sourceArea.equals(that.sourceArea) : that.sourceArea != null) return false;
        if (setDate != null ? !setDate.equals(that.setDate) : that.setDate != null) return false;
        if (sellerId != null ? !sellerId.equals(that.sellerId) : that.sellerId != null) return false;
        if (goodsType != null ? !goodsType.equals(that.goodsType) : that.goodsType != null) return false;
        if (leastAmount != null ? !leastAmount.equals(that.leastAmount) : that.leastAmount != null) return false;
        if (largeAmount != null ? !largeAmount.equals(that.largeAmount) : that.largeAmount != null) return false;
        if (largePrice != null ? !largePrice.equals(that.largePrice) : that.largePrice != null) return false;
        if (picture != null ? !picture.equals(that.picture) : that.picture != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = goodsId != null ? goodsId.hashCode() : 0;
        result = 31 * result + (goodsName != null ? goodsName.hashCode() : 0);
        result = 31 * result + (goodsCount != null ? goodsCount.hashCode() : 0);
        result = 31 * result + (goodsSize != null ? goodsSize.hashCode() : 0);
        result = 31 * result + (goodsIntro != null ? goodsIntro.hashCode() : 0);
        result = 31 * result + (goodsPrice != null ? goodsPrice.hashCode() : 0);
        result = 31 * result + (storeWay != null ? storeWay.hashCode() : 0);
        result = 31 * result + (sourceArea != null ? sourceArea.hashCode() : 0);
        result = 31 * result + (setDate != null ? setDate.hashCode() : 0);
        result = 31 * result + (sellerId != null ? sellerId.hashCode() : 0);
        result = 31 * result + (goodsType != null ? goodsType.hashCode() : 0);
        result = 31 * result + (leastAmount != null ? leastAmount.hashCode() : 0);
        result = 31 * result + (largeAmount != null ? largeAmount.hashCode() : 0);
        result = 31 * result + (largePrice != null ? largePrice.hashCode() : 0);
        result = 31 * result + (picture != null ? picture.hashCode() : 0);
        return result;
    }
}
