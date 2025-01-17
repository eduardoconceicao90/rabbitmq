package io.github.eduardoconceicao90.commons.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {

    private Integer id;
    private String name;
    private Double price;

}
