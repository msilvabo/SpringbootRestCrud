package com.learning.seccion12webapirestful.services;

import com.learning.seccion12webapirestful.entities.Product;
import com.learning.seccion12webapirestful.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)

    @Override
    public List<Product> findall() {
        return (List<Product>) productRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()){
            Product productDB = productOptional.get();
            if (product.getName() != null){
                productDB.setName(product.getName());
            }
            if (product.getPrice() != null){
                productDB.setPrice(product.getPrice());
            }
            if (product.getDescription() != null){
                productDB.setDescription(product.getDescription());
            }
            return Optional.of(productRepository.save(productDB));
        }
        return productOptional;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        productOptional.ifPresent(productDB -> {
            productRepository.delete(productDB);
        } );
        return productOptional;
    }
}
