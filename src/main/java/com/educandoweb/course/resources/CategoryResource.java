package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;

@RestController // Define a classe CategoryResource como um recurso web que é implementado por um controlador rest.
@RequestMapping(value = "/categories") // Define o caminho do meu recurso.
public class CategoryResource { // Controlador
	
	@Autowired
	private CategoryService service;
	
	@GetMapping // Indica que o método findAll() responde a requisição do tipo get do HTTP
	public ResponseEntity<List<Category>> findAll(){   // O método findAll() será um endpoint para acessar os users.
		List<Category> list = service.findAll(); // Chama o método findAll() da classe CategoryService.
		
		return ResponseEntity.ok().body(list); // Define como retorno do método o corpo (body) da list, que é um tipo ResponseEntity. 
	
	}
	
	@GetMapping(value = "/{id}") // Indica que o método findById() responde a requisição do tipo get do HTTP.
	public ResponseEntity<Category> findById(@PathVariable Long id) {
	Category obj = service.findById(id); // Chama o método findAById() da classe CategoryService.
	return ResponseEntity.ok().body(obj); // Define como retorno do método o corpo (body) do obj, que é um tipo ResponseEntity. 
	}

}