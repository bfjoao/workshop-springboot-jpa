package com.bfjoao.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bfjoao.curso.entidades.User;
import com.bfjoao.curso.services.UserService;

@RestController // Transforma esta classe em um controlador REST do Spring Boot.
@RequestMapping(value = "/users") // Define que todas as requisições que começarem com /users serão tratadas por esta classe.
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping // Indica que este método responde a requisições GET em /users.
	public ResponseEntity<List> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // ResponseEntity.ok() → Retorna uma resposta HTTP 200 OK. body(u) → Define o corpo da resposta como o objeto User.
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}