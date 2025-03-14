package com.bfjoao.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bfjoao.curso.entidades.User;

// Faz com que o Spring Data JPA gere automaticamente a implementação dos métodos CRUD (Create, Read, Update, Delete) para a entidade User.
public interface UserRepository extends JpaRepository<User, Long> {  

}
