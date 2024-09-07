package com.project.telco.service;

import javax.sound.midi.SysexMessage;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.project.telco.model.Client;

@Profile("jms-listener")
@Component
public class JmsListenerService {
    
    @JmsListenerService(destination = "tacocloud.order.queuetwo")
    public void receiveOrder(Client client) {
        System.out.println(client);
    }
    
}
