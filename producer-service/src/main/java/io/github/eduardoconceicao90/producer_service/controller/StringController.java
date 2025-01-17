package io.github.eduardoconceicao90.producer_service.controller;

import io.github.eduardoconceicao90.producer_service.service.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produces")
public class StringController {

    @Autowired
    public StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("message") String message) {
        service.produce(message);
        return ResponseEntity.ok().body("Message sent to RabbitMQ");
    }

}
