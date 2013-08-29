package com.springapp.dao;

import com.springapp.model.StockEntity;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StockDAO {
    void save(StockEntity stock);
    void update(StockEntity stock);
    void delete(StockEntity stock);
    StockEntity findByStockCode(String stockCode);
}
