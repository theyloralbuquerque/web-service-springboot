package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAIMENT(1),
	PAID(2),
	SHPPEED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus (int code) { // Construtor para o tipo enumerado.
		this.code = code;
	}

	public int getCode() { // Método para acessar o atributo code.
		return code;
	}
	
	// Método que converte um valor numérico para um valor do tipo enumerado.
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) { // Para cada valor do tipo OrderStatus da coleção OrderStatus.values().
			if (value.getCode() == code) { // Se o valor do enum for igual ao code recebido como parâmetro.
				return value; // Retorne o valor.
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code"); // Caso não haja nenhum retorno será lançada essa exceção.
	}
}