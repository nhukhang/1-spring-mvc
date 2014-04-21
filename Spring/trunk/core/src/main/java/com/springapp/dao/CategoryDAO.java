package com.springapp.dao;

import com.springapp.model.CategoryEntity;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/14/13
 * Time: 10:34 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryDAO {
    public void save(CategoryEntity entity);
    public void update(CategoryEntity entity);
    public CategoryEntity findByUniqueUrl(String url, Boolean isRoot);
}
