package io.github.eduardoconceicao90.consumer_service.rabbitmq.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eduardoconceicao90.consumer_service.dto.ProductDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

//    @RabbitListener(queues = {"product.log"})
//    public void consumerLog(ProductDTO dto) {
//        System.out.println("Mensagem recebida pelo consumer: " + dto);
//    }

    @RabbitListener(queues = {"product.log"})
    public String consumerLog(ProductDTO dto) throws JsonProcessingException {
        System.out.println("Mensagem recebida pelo consumer: " + dto);

        /* POSSO CRIAR ALGUM LOGICA E RETORNAR ESSA INFORMAÇÃO DE VOLTA AO PRODUTOR */

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString("Retorno para o producer: " + dto);
    }

}
