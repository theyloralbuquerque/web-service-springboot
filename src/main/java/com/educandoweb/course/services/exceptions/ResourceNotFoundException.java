package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	// Construtor que recebe um id como parâmetro e retorna uma mensagem para a superclasse.
	public ResourceNotFoundException(Object id) {
	 	super("Resource not found. Id " + id);
	}

}