package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entidades.Category;
import com.example.demo.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> cat = categoryService.findAll();
        return ResponseEntity.ok().body(cat);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findByID(@PathVariable long id){
        Category cat = categoryService.findByID(id);
        return ResponseEntity.ok().body(cat);
    }

    @PostMapping
    public ResponseEntity<Category> insert(Category cat){
        cat = categoryService.insert(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).body(cat);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody Category cat){
        cat = categoryService.update(id, cat);
        return ResponseEntity.ok().body(cat);
    }
}
