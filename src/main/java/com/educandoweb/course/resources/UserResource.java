package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

@RestController // Define a classe UserResource como um recurso web que é implementado por um controlador rest.
@RequestMapping(value = "/users") // Define o caminho do meu recurso.
public class UserResource { // Controlador
	
	@Autowired
	private UserService service;
	
	@GetMapping // Indica que o método findAll() responde a requisição do tipo get do HTTP
	public ResponseEntity<List<User>> findAll(){   // O método findAll() será um endpoint para acessar os users.
		List<User> list = service.findAll(); // Chama o método findAll() da classe UserService.
		return ResponseEntity.ok().body(list); // Define como retorno do método o corpo (body) da list, que é um tipo ResponseEntity. 
	
	}
	
	@GetMapping(value = "/{id}") // Indica que o método findById() responde a requisição do tipo get do HTTP.
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id); // Chama o método findAById() da classe UserService.
		return ResponseEntity.ok().body(obj); // Define como retorno do método o corpo (body) do obj, que é um tipo ResponseEntity. 
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj){ // @RequestBody informa ao spring que o corpo da solicitação deve ser desserializado e vinculado ao parâmetro anotado.
		obj = service.insert(obj); // Chama o método insert na classe UserService passando como parâmetro o obj.
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj); // Define como retorno do método a criação de umUser e o corpo (body) do obj, que é um tipo ResponseEntity. 
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){ // @PathVariable serve para que o Long id seja reconhecido como uma variável da minha URL.
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	// @RequestBody informa ao framework que o corpo da solicitação deve ser desserializado e vinculado ao parâmetro anotado.
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) { 
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}