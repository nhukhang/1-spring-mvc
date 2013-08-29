package com.springapp.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/29/13
 * Time: 5:26 PM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "stock", schema = "", catalog = "learning")
@Entity
public class StockEntity {
    private int stockId;
    private String stockCode;
    private String stockName;

    @javax.persistence.Column(name = "STOCK_ID", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Id
    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    @javax.persistence.Column(name = "STOCK_CODE", nullable = false, insertable = true, updatable = true, length = 10, precision = 0)
    @Basic
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @javax.persistence.Column(name = "STOCK_NAME", nullable = false, insertable = true, updatable = true, length = 20, precision = 0)
    @Basic
    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockEntity that = (StockEntity) o;

        if (stockId != that.stockId) return false;
        if (stockCode != null ? !stockCode.equals(that.stockCode) : that.stockCode != null) return false;
        if (stockName != null ? !stockName.equals(that.stockName) : that.stockName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockId;
        result = 31 * result + (stockCode != null ? stockCode.hashCode() : 0);
        result = 31 * result + (stockName != null ? stockName.hashCode() : 0);
        return result;
    }
}
