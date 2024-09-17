package com.project.telco.service;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import com.project.telco.model.Client;

import jakarta.jms.JMSException;

@Component
public class JmsOrderReceiver {
    private JmsTemplate jms;

    public JmsOrderReceiver(JmsTemplate jms) {
        this.jms = jms;

    }

    public Client receiveOrder() throws MessageConversionException, JMSException {
        return (Client) jms.receiveAndConvert("tacocloud.order.queuetwo");
        
    }


    
}
