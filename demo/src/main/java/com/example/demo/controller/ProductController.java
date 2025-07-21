package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> prod = productService.findAll();
        if (prod.isEmpty()) {
            return ResponseEntity.noContent().build(); // Retorna 204 se a lista estiver vazia.
        }
        return ResponseEntity.ok().body(prod);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id){
        Product prod = productService.findByID(id);

        if (prod == null) {
            return ResponseEntity.notFound().build(); // Retorna o erro 404 se não for encontrado.
        }

        return ResponseEntity.ok().body(prod);
    }
}
