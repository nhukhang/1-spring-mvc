package com.springapp.common.dto;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/8/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryDTO implements Serializable {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String url;
    private String name;
}
