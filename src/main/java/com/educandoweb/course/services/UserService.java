package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

@Service // Registra a classe UserService no mecanismo de injeção de dependência do spring.
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	// Vai chamar o método findAll() (do JpaRepository) do repository e retornar uma Lista de User.
	public List<User> findAll() { 
		return repository.findAll(); // .findAll() chamado a partir de um objeto JpaRepository recupera todas as entidades no BD e retorna em formato de Lista.
	}
	
	// Método que busca um usuário por id.
	public User findById(Long id) { 
		Optional<User> obj = repository.findById(id); // .findById(id) chamado a partir de um objeto JpaRepository recupera no BD o id recebido como parâmetro e retorna em formato de Optional.
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // orElseThrow() vai tentar o get(), se não tiver User no obj, ele lança a exceção dentro dos parênteses.
	}

	// Método responsável por inserir um usuário no BD.
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	// Método que deleta um User do BD.
	public void delete(Long id) {
		repository.deleteById(id); // O método deleteById() do repository deleta um elemento do BD pelo id passado como parâmetro.
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id); // getReferenceById(id) pega a referência do id do objeto, mas não vai no BD ainda.
		updateData(entity, obj);
		return repository.save(entity); // Retorna a entidade salva no repositório.
	}

	// Método que atualiza os dados do entity com base nos dados armazenados em obj.
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());   // Atualização do entity passando como parâmetro os atributos contidos no obj.
		entity.setEmail(obj.getEmail()); // Dessa forma o entity irá receber o name, email e phone contidos no obj.
		entity.setPhone(obj.getPhone());
	}


}