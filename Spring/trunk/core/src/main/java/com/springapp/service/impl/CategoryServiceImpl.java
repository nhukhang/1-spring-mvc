package com.springapp.service.impl;

import com.springapp.dao.CategoryDAO;
import com.springapp.model.CategoryEntity;
import com.springapp.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/14/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    private CategoryDAO categoryDAO;

    @Override
    public void save(CategoryEntity entity) {
        this.categoryDAO.save(entity);
    }
}
