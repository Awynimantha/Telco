package com.project.telco.messaging;

import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DestinationConfig {
    @Bean
    public jakarta.jms.Destination orderQueue() {
        return new ActiveMQQueue("tacocloud.order.queuetwo");

    }

    
}
