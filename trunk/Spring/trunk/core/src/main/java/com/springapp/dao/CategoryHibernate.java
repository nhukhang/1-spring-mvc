package com.springapp.dao;

import com.springapp.model.CategoryEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/14/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryHibernate extends CustomHibernateDaoSupport implements CategoryDAO {
    @Override
    public void save(CategoryEntity entity) {
        this.getHibernateTemplate().save(entity);
    }

    @Override
    public void update(CategoryEntity entity) {
        this.getHibernateTemplate().update(entity);
    }

    @Override
    public CategoryEntity findByUniqueUrl(String url, Boolean isRoot) {
        StringBuffer stringBuffer = new StringBuffer("FROM CategoryEntity ct WHERE ct.url = ?");
        if(isRoot != null && isRoot){
            stringBuffer.append(" AND ct.categoryByParentId IS NULL");
        }else{
            stringBuffer.append(" AND ct.categoryByParentId IS NOT NULL");
        }
        List list = this.getHibernateTemplate().find(stringBuffer.toString(), url);
        return (list.size() > 0 ? (CategoryEntity)list.get(0) : null);
    }
}
