package io.github.eduardoconceicao90.consumer_service.rabbitmq.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eduardoconceicao90.consumer_service.dto.ProductDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

//    @RabbitListener(queues = {"product.log"})
//    public void consumerLog(ProductDTO dto) {
//        System.out.println("Mensagem tipo objeto, recebida pelo consumer: " + dto);
//    }

//    @RabbitListener(queues = {"product.log"})
//    public String consumerLog(ProductDTO dto) throws JsonProcessingException {
//        System.out.println("Mensagem tipo objeto, recebida pelo consumer: " + dto);
//
//        /* POSSO CRIAR ALGUM LÓGICA E RETORNAR ESSA INFORMAÇÃO DE VOLTA AO PRODUTOR */
//
//        var mapper = new ObjectMapper();
//        return mapper.writeValueAsString("Retorno para o producer: " + dto);
//    }

    @RabbitListener(queues = {"product.log"})
    public String consumerLog(@Payload String payload) throws JsonProcessingException {
        var mapper = new ObjectMapper();
        var dados = mapper.readValue(payload, ProductDTO.class);
        System.out.println("Mensagem tipo objeto, recebida pelo consumer: " + dados);

        /* POSSO CRIAR ALGUM LÓGICA E RETORNAR ESSA INFORMAÇÃO DE VOLTA AO PRODUTOR */

        var productDTO = ProductDTO.builder()
                .id(dados.getId())
                .name("Calabreso retornando kkkkkk...")
                .price(dados.getPrice())
                .build();

        return mapper.writeValueAsString("Retorno para o producer: " + productDTO);
    }

}
