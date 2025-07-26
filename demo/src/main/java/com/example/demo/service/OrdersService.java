package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Orders;
import com.example.demo.repository.OrdersRepository;
import com.example.demo.service.ResourcesException.DataBaseException;
import com.example.demo.service.ResourcesException.ResourcesNotFoundException;

@Service
public class OrdersService {
    
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findByID(Long id){
        Optional<Orders> obj = ordersRepository.findById(id);
        return obj.orElseThrow(() -> new ResourcesNotFoundException(id));
    }

    public void delete(Long id){
        try {
            ordersRepository.deleteById(id);

        } catch (EmptyResultDataAccessException e) {
            throw new ResourcesNotFoundException(id);
        } catch (DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }
}
