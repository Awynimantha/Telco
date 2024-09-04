package com.project.telco.service;

import org.apache.activemq.artemis.api.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.project.telco.model.Client;

import jakarta.jms.Destination;
import jakarta.jms.JMSException;
import jakarta.jms.ObjectMessage;
import jakarta.jms.Session;
@Service
public class JmsUserMessagingService implements UserMessagingService {
    private JmsTemplate jms;
    private Destination orderq;
    
    public JmsUserMessagingService(JmsTemplate jms, Destination orderq) {
        this.jms = jms;
        this.orderq = orderq;
    }
    
    @Override
    public void sendClient(Client client) {
        jms.send(this.orderq, new MessageCreator(){
            @Override
            public ObjectMessage createMessage(Session session) throws JMSException {
                return session.createObjectMessage(client);
            }     
        });
    }

    
    public void sendClientObj(Client client) {
        jms.convertAndSend(client);
    }
}
