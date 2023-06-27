package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;

@RestController // Define a classe ProductResource como um recurso web que é implementado por um controlador rest.
@RequestMapping(value = "/products") // Define o caminho do meu recurso.
public class ProductResource { // Controlador
	
	@Autowired
	private ProductService service;
	
	@GetMapping // Indica que o método findAll() responde a requisição do tipo get do HTTP
	public ResponseEntity<List<Product>> findAll(){   // O método findAll() será um endpoint para acessar os users.
		List<Product> list = service.findAll(); // Chama o método findAll() da classe ProductService.
		
		return ResponseEntity.ok().body(list); // Define como retorno do método o corpo (body) da list, que é um tipo ResponseEntity. 
	}
	
	@GetMapping(value = "/{id}") // Indica que o método findById() responde a requisição do tipo get do HTTP.
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = service.findById(id); // Chama o método findAById() da classe ProductService.
		
		return ResponseEntity.ok().body(obj); // Define como retorno do método o corpo (body) do obj, que é um tipo ResponseEntity. 
	}

}