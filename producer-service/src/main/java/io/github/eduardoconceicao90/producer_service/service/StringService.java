package io.github.eduardoconceicao90.producer_service.service;

import io.github.eduardoconceicao90.producer_service.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StringService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        System.out.println("Received message " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, message);
    }

}
