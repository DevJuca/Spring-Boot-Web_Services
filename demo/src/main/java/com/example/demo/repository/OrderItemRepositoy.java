package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.OrderItem;
import com.example.demo.entidades.PK.OrderItemPK;

public interface OrderItemRepositoy extends JpaRepository<OrderItem, OrderItemPK> {
    
}
