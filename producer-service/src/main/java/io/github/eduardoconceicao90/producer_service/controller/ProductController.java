package io.github.eduardoconceicao90.producer_service.controller;

import io.github.eduardoconceicao90.producer_service.dto.ProductDTO;
import io.github.eduardoconceicao90.producer_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    public ProductService service;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) {
        service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
