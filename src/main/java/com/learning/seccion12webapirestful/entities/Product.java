package com.learning.seccion12webapirestful.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty.product.name}")
    @Size(min = 3, max = 25)
    private String name;

    @Min(value= 200, message = "{Min.product.price}")
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;

    @NotEmpty(message = "{NotEmpty.product.name}")
    @NotBlank(message = "{NotBlank.product.description}")
    private String description;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
