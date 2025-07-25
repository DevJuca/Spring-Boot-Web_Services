package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

        if (ord.isEmpty()) {
            ResponseEntity.noContent().build(); // Retorna 204 se a lista estiver vazia.
        }

        return ResponseEntity.ok().body(ord);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Orders> findByID(@PathVariable Long id){
        Orders ord = ordersService.findByID(id);

        if (ord == null) {
            return ResponseEntity.notFound().build(); // Retorna o erro 404 se não for encontrado.
        }

        return ResponseEntity.ok().body(ord);
    }
}
