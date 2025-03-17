package com.bfjoao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfjoao.curso.entidades.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {  

}
