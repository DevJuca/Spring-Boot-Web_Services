package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Category;
import com.example.demo.repository.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository CategoryRepository;

    public List<Category> findAll(){
        return CategoryRepository.findAll();
    }

    public Category findByID(Long id){
        Optional<Category> obj = CategoryRepository.findById(id);
        return obj.get();
    }
}
