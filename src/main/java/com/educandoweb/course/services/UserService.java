package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		try {
			repository.deleteById(id); // O método deleteById() do repository deleta um elemento do BD pelo id passado como parâmetro.
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id); // getReferenceById(id) pega a referência do id do objeto, mas não vai no BD ainda.
			updateData(entity, obj);
			return repository.save(entity); // Retorna a entidade salva no repositório.
		}
		catch (EntityNotFoundException e) {
			e.printStackTrace();
			throw new ResourceNotFoundException(id);
		}
	}

	// Método que atualiza os dados do entity com base nos dados armazenados em obj.
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());   // Atualização do entity passando como parâmetro os atributos contidos no obj.
		entity.setEmail(obj.getEmail()); // Dessa forma o entity irá receber o name, email e phone contidos no obj.
		entity.setPhone(obj.getPhone());
	}


}