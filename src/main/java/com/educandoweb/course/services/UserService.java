package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

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
		return obj.get(); // get() do Optional vai pegar um objeto que estiver dentro do obj, que é um objeto Optional.
	}

}
