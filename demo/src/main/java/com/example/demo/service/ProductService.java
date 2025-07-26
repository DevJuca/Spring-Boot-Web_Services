package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public Product findByID(Long id){
        Optional<Product> obj = productRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    public Product insert(Product obj){
        return productRepository.save(obj);
    }

    public void delete(Long id){
        try {
            productRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public Product update(Long id, Product obj){
        try {
            Product entity = productRepository.getReferenceById(id);
            updateData(entity, obj);
            return productRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourcesNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj){
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
    }
}
