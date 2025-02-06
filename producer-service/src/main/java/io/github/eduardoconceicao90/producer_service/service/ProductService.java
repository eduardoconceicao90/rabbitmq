package io.github.eduardoconceicao90.producer_service.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eduardoconceicao90.producer_service.config.RabbitMQConfig;
import io.github.eduardoconceicao90.producer_service.dto.ProductDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    public void createProduct(ProductDTO dto) {
//        System.out.println("Mensagem enviada para exchange: " + dto.toString());
//        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, dto);
//    }

//    public void createProduct(ProductDTO dto) {
//        System.out.println("Mensagem enviada para exchange: " + dto.toString());
//        var retorno = (String) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXG_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, dto);
//        System.out.println(retorno);
//    }

    public void createProduct(ProductDTO dto) throws JsonProcessingException {
        var json = convertIntoJson(dto);
        System.out.println("Mensagem enviada para exchange: " + json);
        var retorno = (String) rabbitTemplate.convertSendAndReceive(RabbitMQConfig.EXG_MARKETPLACE, RabbitMQConfig.RK_PRODUCT_LOG, json);
        System.out.println(retorno);
    }

    private String convertIntoJson(ProductDTO dto) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dto);
    }

}
