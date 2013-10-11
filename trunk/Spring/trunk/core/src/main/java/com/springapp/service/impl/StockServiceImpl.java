package com.springapp.service.impl;

import com.springapp.dao.StockDAO;
import com.springapp.model.StockEntity;
import com.springapp.service.StockService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("stockService")
public class StockServiceImpl implements StockService{

    public void setStockDAO(StockDAO stockDAO) {
        this.stockDAO = stockDAO;
    }

    private StockDAO stockDAO;

    @Override
    public void save(StockEntity stock) {
        this.stockDAO.save(stock);
    }

    @Override
    public void update(StockEntity stock) {
        this.stockDAO.update(stock);
    }

    @Override
    public void delete(StockEntity stock) {
        this.stockDAO.delete(stock);
    }

    @Override
    public StockEntity findByStockCode(String stockCode) {
        return this.stockDAO.findByStockCode(stockCode);
    }
}
