package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entidades.Orders;
import com.example.demo.service.OrdersService;

@RestController
@RequestMapping(value = "/orders")
public class OrdersController {
    
    @Autowired
    private OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<Orders>> findAll(){
        List<Orders> ord = ordersService.findAll(); 
        return ResponseEntity.ok().body(ord);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findByID(@PathVariable Long id){
        Orders ord = ordersService.findByID(id);
        return ResponseEntity.ok().body(ord);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        ordersService.delete(id);
        return ResponseEntity.notFound().build();
    }
}
