package com.empresa.peloteros.exception;

public class ComplejoDeportivoNoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ComplejoDeportivoNoEncontradoException() {
		super("El Complejo deportivo no se ha encontrado.");
	}

	public ComplejoDeportivoNoEncontradoException(String mensaje) {
		super(mensaje);
	}

}
