package com.swiggy.resturant.OrderConsumer.consumer;

import javax.jms.JMSException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.swiggy.resturant.OrderConsumer.model.Order;

@Component
public class MessageConsumer {

    @JmsListener(destination = "myqueue")
    public void receiveMessage(Order message) throws JMSException {
        System.out.println("Received message in consumer" + message);
    }
}
