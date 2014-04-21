package com.springapp.service.impl;

import com.springapp.common.dto.CategoryDTO;
import com.springapp.common.utils.Constants;
import com.springapp.dao.CategoryDAO;
import com.springapp.model.CategoryEntity;
import com.springapp.service.CategoryService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/8/13
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    private String url;
    private CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> getMainCategories() throws IOException {
        Document doc = null;
        List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
        try{
            doc = Jsoup.connect(Constants.HOME_PAGE).userAgent(Constants.userAgent).get();
            Elements links = doc.getElementsByClass("nav-site-section").select("a[href]");
            for (Element link : links) {
                CategoryDTO dto = new CategoryDTO();
                dto.setUrl(link.attr("href"));
                dto.setName(link.text());
                categories.add(dto);
            }
        }catch (IOException e){
             throw new IOException("Exception: " + e.getMessage());
        }
        return categories;
    }

    @Override
    public List<CategoryDTO> getGeneralCategories() throws IOException {
        Document doc = null;
        List<CategoryDTO> categories = new ArrayList<CategoryDTO>();
        try{
            doc = Jsoup.connect(Constants.GENERAL_PAGE).userAgent(Constants.userAgent).get();
            Elements links = doc.getElementsByClass("nav-general").get(0).getElementsByClass("level-2").select("a[href]");
            CategoryEntity entity = categoryDAO.findByUniqueUrl(Constants.GENERAL_PAGE, Boolean.TRUE);
            for (Element link : links) {
                CategoryDTO dto = new CategoryDTO();
                dto.setUrl(link.attr("href"));
                dto.setName(link.text());
                dto.setParentId(entity.getId());
                categories.add(dto);
            }
        }catch (IOException e){
            throw new IOException("Exception: " + e.getMessage());
        }
        return categories;
    }
}
