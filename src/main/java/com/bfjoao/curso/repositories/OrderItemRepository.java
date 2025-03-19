package com.bfjoao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfjoao.curso.entidades.OrderItem;
import com.bfjoao.curso.entidades.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {  

}
