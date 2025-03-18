package com.bfjoao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfjoao.curso.entidades.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {  

}
