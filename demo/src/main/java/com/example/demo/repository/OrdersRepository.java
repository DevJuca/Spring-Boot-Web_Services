package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entidades.Orders;


public interface OrdersRepository extends JpaRepository<Orders, Long> {}
