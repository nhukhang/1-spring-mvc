package com.springapp.dao;

import com.springapp.model.StockEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 8/27/13
 * Time: 10:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Repository("stockDAO")
public class StockHibernate extends CustomHibernateDaoSupport implements StockDAO {
    @Override
    public void save(StockEntity stock) {
        this.getHibernateTemplate().save(stock);
    }

    @Override
    public void update(StockEntity stock) {
        this.getHibernateTemplate().update(stock);
    }

    @Override
    public void delete(StockEntity stock) {
        this.getHibernateTemplate().delete(stock);
    }

    @Override
    public StockEntity findByStockCode(String stockCode) {
        StringBuffer stringBuffer = new StringBuffer("from StockEntity where stockCode = ?");
        List list = this.getHibernateTemplate().find(stringBuffer.toString(), stockCode);
        return (StockEntity)list.get(0);
    }
}
