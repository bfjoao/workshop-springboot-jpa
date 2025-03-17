package com.bfjoao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfjoao.curso.entidades.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {  

}
