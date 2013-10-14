package com.springapp.dao;

import com.springapp.model.CategoryEntity;

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
}
