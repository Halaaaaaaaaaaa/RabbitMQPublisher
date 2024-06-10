package com.tisquare.rabbitmq.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {RabbitMQPublisherApplication.class})
@EnableRabbit
public class RabbitMQPublisherApplication {

    private static Logger logger = LoggerFactory.getLogger(RabbitMQPublisherApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(RabbitMQPublisherApplication.class, args);
        logger.info("===================================================================================");

    }
}