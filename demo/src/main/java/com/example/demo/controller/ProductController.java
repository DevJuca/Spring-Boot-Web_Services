package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
        return ResponseEntity.ok().body(prod);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findByID(@PathVariable Long id){
        Product prod = productService.findByID(id);
        return ResponseEntity.ok().body(prod);
    }

    @PostMapping
    public ResponseEntity<Product> insert(@RequestBody Product prod){
        prod = productService.insert(prod);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId()).toUri();
        return ResponseEntity.created(uri).body(prod);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> update(@PathVariable long id, @RequestBody Product prod){
        prod = productService.update(id, prod);
        return ResponseEntity.ok().body(prod);
    }
}
