package com.springapp.service.impl;

import com.springapp.model.StockEntity;
import com.springapp.service.StockService;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Service("stockService")
public class StockServiceImpl implements StockService {

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    private HibernateTemplate hibernateTemplate;

    @Override
    public void save(StockEntity stock) {
        this.hibernateTemplate.save(stock);
    }

    @Override
    public void update(StockEntity stock) {
        this.hibernateTemplate.update(stock);
    }

    @Override
    public void delete(StockEntity stock) {
        this.hibernateTemplate.delete(stock);
    }

    @Override
    public StockEntity findByStockCode(String stockCode) {
        StringBuffer stringBuffer = new StringBuffer("from StockEntity where stockCode = ?");
        List list = this.hibernateTemplate.find(stringBuffer.toString(), 0, stockCode);
        return (StockEntity)list.get(0);
    }
}
