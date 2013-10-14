package com.springapp.jms;

import com.springapp.common.dto.CategoryDTO;
import org.apache.activemq.command.ActiveMQObjectMessage;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/11/13
 * Time: 10:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryObjConsumerMessageService implements MessageListener {

    @Override
    public void onMessage(Message message) {
        if(message instanceof ActiveMQObjectMessage){
            try{
                CategoryDTO categoryDTO = (CategoryDTO) ((ObjectMessage) message).getObject();
                System.out.println("Received: " + categoryDTO.toString());
            }catch (JMSException e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("******** Not type of ActiveMQObjectMessage");
        }
    }
}
