package com.springapp.dao;

import com.springapp.model.Stock;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class StockHibernate extends CustomHibernateDaoSupport implements StockDAO {
    @Override
    public void save(Stock stock) {
        this.getHibernateTemplate().save(stock);
    }

    @Override
    public void update(Stock stock) {
        this.getHibernateTemplate().update(stock);
    }

    @Override
    public void delete(Stock stock) {
        this.getHibernateTemplate().delete(stock);
    }

    @Override
    public Stock findByStockCode(String stockCode) {
        StringBuffer stringBuffer = new StringBuffer("from Stock where stockCode = ?");
        List list = this.getHibernateTemplate().find(stringBuffer.toString(), stockCode);
        return (Stock)list.get(0);
    }
}
