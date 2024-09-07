package com.project.telco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import com.project.telco.model.Client;

import jakarta.jms.JMSException;
import jakarta.jms.Message;

@Component
public class JmsOrderReceiver {
    private JmsTemplate jms;
    private MessageConverter converter;
    public JmsOrderReceiver(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    public Client receiveOrder() throws MessageConversionException, JMSException {
        Message message = jms.receive("tacocloud.order.queuetwo");
        return (Client) converter.fromMessage(message);
    }


    
}
