package com.bfjoao.curso.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfjoao.curso.entidades.User;

@RestController // Transforma esta classe em um controlador REST do Spring Boot.
@RequestMapping(value = "/users") // Define que todas as requisições que começarem com /users serão tratadas por esta classe.
public class UserResource {

	@GetMapping // Indica que este método responde a requisições GET em /users.
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "99999999", "12345");
		return ResponseEntity.ok().body(u); // ResponseEntity.ok() → Retorna uma resposta HTTP 200 OK. body(u) → Define o corpo da resposta como o objeto User.
	}
}