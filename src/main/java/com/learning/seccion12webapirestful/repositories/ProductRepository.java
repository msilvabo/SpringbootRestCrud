package com.learning.seccion12webapirestful.repositories;

import com.learning.seccion12webapirestful.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
