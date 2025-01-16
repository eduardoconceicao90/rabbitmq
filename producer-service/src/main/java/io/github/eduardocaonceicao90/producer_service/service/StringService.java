package io.github.eduardocaonceicao90.producer_service.service;

import io.github.eduardocaonceicao90.producer_service.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public void produce(String message) {
        log.info("Received message " + message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, message);
    }

}
