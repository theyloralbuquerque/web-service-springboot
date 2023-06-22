package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

@RestController // Define a classe UserResource como um recurso web que é implementado por um controlador rest.
@RequestMapping(value = "/users") // Define o caminho do meu recurso.
public class UserResource {
	
	@GetMapping // Indica que o método findAll() responde a requisição do tipo get do HTTP
	public ResponseEntity<User> findAll(){   // O método findAll() será um endpoint para acessar os users.
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return  ResponseEntity.ok().body(u); // Define como retorno do método um tipo o corpo (body) de u, que é um tipo ResponseEntity. 
	
	}
}