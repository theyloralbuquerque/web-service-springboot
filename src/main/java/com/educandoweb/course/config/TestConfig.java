package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Configuration    // "Fala" pro spring que essa é uma classe específica de configuração.
@Profile("test")  // "Fala" para o spring que essa é uma classe vai ser uma configuração específica para o perfil test.
public class TestConfig implements CommandLineRunner { // CommandLineRunner permite que eu execute um código específico após o contexto da aplicação ter sido carregado, mas antes que a aplicação seja iniciada.
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception { // Método do contrato de CommandLineRunner, run() define a lógica a ser executada quando a aplicação é iniciada. 
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // saveAll() chamado a partir de um Repository salva objetos no BD.
		
	}

}
