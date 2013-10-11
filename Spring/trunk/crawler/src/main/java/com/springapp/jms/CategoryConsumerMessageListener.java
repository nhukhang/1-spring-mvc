package com.springapp.jms;

import com.springapp.common.dto.CategoryDTO;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/11/13
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryConsumerMessageListener implements MessageListener {

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    private CategoryDTO category;

    @Override
    public void onMessage(Message message) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
