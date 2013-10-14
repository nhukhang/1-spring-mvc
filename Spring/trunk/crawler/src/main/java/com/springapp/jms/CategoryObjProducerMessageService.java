package com.springapp.jms;

import com.springapp.common.dto.CategoryDTO;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 * User: nkhang
 * Date: 10/11/13
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class CategoryObjProducerMessageService {

    private JmsTemplate jmsTemplate;
    private Destination destination;

    public void sendMessage(final CategoryDTO category){
        jmsTemplate.send(destination, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage();
                objectMessage.setObject(category);
                System.out.println("Sent: " + category.toString());
                return objectMessage;
            }
        });
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

}
