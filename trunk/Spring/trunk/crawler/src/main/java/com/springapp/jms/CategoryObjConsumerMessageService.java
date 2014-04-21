package com.springapp.jms;

import com.springapp.common.dto.CategoryDTO;
import com.springapp.dao.CategoryDAO;
import com.springapp.model.CategoryEntity;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/11/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class CategoryObjConsumerMessageService implements MessageListener {

    private CategoryDAO categoryDAO;

    @Override
    public void onMessage(Message message) {
        if(message instanceof ActiveMQObjectMessage){
            try{
                CategoryDTO categoryDTO = (CategoryDTO) ((ObjectMessage) message).getObject();
                categoryDAO.save(dto2Entity(categoryDTO));
                System.out.println("Inserted: " + categoryDTO.toString());
            }catch (JMSException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("******** Not type of ActiveMQObjectMessage");
        }
    }

    public void setCategoryDAO(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    private CategoryEntity dto2Entity(CategoryDTO dto){
        CategoryEntity entity = new CategoryEntity();
        entity.setUrl(dto.getUrl());
        entity.setCode(dto.getUrl());
        entity.setTitle(dto.getName());
        if(dto.getParentId() != null){
            CategoryEntity parent = new CategoryEntity();
            parent.setId(dto.getParentId());
            entity.setCategoryByParentId(parent);
        }
        entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
        return entity;
    }
}
