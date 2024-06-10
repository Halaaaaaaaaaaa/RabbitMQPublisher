package com.tisquare.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Service
public class PublisherMessageSender {

    private static Logger logger = LoggerFactory.getLogger(PublisherMessageSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange.name}")
    private String exchangeName;

    @Value("${spring.rabbitmq.routing.name}")
    private String routingKey;


    public void sendToQueue(LogMessage logMessage) {
        //TODO log pattern [taskname] routing key에서 추출
        String[] routingKeyParts = routingKey.split("\\.");
        logMessage.setTaskname(routingKeyParts[1]);
        logMessage.setHostname(routingKeyParts[2]);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, logMessage.toString());
    }

}
