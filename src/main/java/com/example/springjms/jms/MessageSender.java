package com.example.springjms.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("{springjms.myQueue}")
    private String queue;

    public void send(String message) {
        System.out.println("Message Sended: "+message);
        MessageCreator messageCreator = s -> s.createTextMessage(message);
        jmsTemplate.send(queue, messageCreator);
    }

}
