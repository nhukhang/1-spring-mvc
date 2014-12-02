package com.springapp.service;

import com.springapp.common.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/8/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface CategoryService {
    List<CategoryDTO> getMainCategories() throws IOException;
    List<CategoryDTO> getGeneralCategories() throws IOException;
    List<CategoryDTO> getLanguageCategories() throws IOException;
}
