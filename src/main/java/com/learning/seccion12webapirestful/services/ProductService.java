package com.learning.seccion12webapirestful.services;

import com.learning.seccion12webapirestful.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findall();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id, Product product);
    Optional<Product> delete(Long id);
}
