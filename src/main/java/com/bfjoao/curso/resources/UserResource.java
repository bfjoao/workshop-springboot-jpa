package com.bfjoao.curso.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}