package com.springapp.service;

import com.springapp.model.StockEntity;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StockService {
    void save(StockEntity stock);
    void update(StockEntity stock);
    void delete(StockEntity stock);
    StockEntity findByStockCode(String stockCode);
}
