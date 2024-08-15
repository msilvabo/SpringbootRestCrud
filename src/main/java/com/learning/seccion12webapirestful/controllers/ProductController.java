package com.learning.seccion12webapirestful.controllers;

import com.learning.seccion12webapirestful.entities.Product;
import com.learning.seccion12webapirestful.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<Product> list(){
        return service.findall();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> view(@PathVariable Long id){
        Optional<Product> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else{
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody Product product){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Product product = new Product();
        product.setId(id);
        Optional<Product> productOptional = service.delete(product);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.orElseThrow());
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
