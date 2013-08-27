package com.springapp.service;

import com.springapp.model.Stock;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:46 PM
 * To change this template use File | Settings | File Templates.
 */
public interface StockService {
    void save(Stock stock);
    void update(Stock stock);
    void delete(Stock stock);
    Stock findByStockCode(String stockCode);
}
