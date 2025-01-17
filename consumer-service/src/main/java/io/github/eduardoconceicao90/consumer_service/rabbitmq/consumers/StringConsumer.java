package io.github.eduardoconceicao90.consumer_service.rabbitmq.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StringConsumer {

    @RabbitListener(queues = {"product.log"})
    public void consumer(String message) {

        System.out.println("Consumer received a message " + message);
    }

}
