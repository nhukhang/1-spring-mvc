package com.springapp.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/26/13
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "stock", catalog = "learning", uniqueConstraints = {
        @UniqueConstraint(columnNames = "STOCK_NAME"),
        @UniqueConstraint(columnNames = "STOCK_CODE") })
public class Stock implements Serializable {
    private Integer stockId;
    private String stockCode;
    private String stockName;

    public Stock() {
    }

    public Stock(String stockCode, String stockName) {
        this.stockCode = stockCode;
        this.stockName = stockName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    public Integer getStockId() {
        return this.stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    @Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
    public String getStockCode() {
        return this.stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    public String getStockName() {
        return this.stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public String toString() {
        return "Stock [stockCode=" + stockCode + ", stockId=" + stockId
                + ", stockName=" + stockName + "]";
    }
}
