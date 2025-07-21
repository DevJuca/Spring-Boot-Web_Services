package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entidades.Orders;
import com.example.demo.repository.OrdersRepository;

@Service
public class OrdersService {
    
    @Autowired
    private OrdersRepository ordersRepository;

    public List<Orders> findAll(){
        return ordersRepository.findAll();
    }

    public Orders findByID(Long id){
        Optional<Orders> obj = ordersRepository.findById(id);
        return obj.get();
    }
}
