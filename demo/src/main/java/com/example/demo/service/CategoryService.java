package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    private final ClientRepository clientRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findByID(Long id){
        Optional<Category> obj = categoryRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    public Category insert(Category obj){
        return categoryRepository.save(obj);
    }

    public void delete(long id){
        try {
            categoryRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Category update(Long id, Category obj){
        try {
            Category entity = categoryRepository.getReferenceById(id);
            updateData(entity, obj);
            return categoryRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateData(Category entity, Category obj){
        entity.setName(obj.getName());
    }
}
