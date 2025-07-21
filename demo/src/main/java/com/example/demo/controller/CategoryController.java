package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    
    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> cat = CategoryService.findAll();
        
        if (cat.isEmpty()) {
            ResponseEntity.noContent().build(); // Retorna 204 se a lista estiver vazia.
        }

        return ResponseEntity.ok().body(cat);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findByID(@PathVariable long id){
        Category cat = CategoryService.findByID(id);

        if (cat == null) {
            return ResponseEntity.notFound().build(); // Retorna o erro 404 se não for encontrado.
        }

        return ResponseEntity.ok().body(cat);
    }
}
