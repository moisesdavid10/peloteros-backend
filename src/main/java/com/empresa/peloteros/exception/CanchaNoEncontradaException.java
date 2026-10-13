package com.empresa.peloteros.exception;

public class CanchaNoEncontradaException extends RuntimeException{


	private static final long serialVersionUID = 1L;

	public CanchaNoEncontradaException() {
		super("La cancha sintetica no se ha encontrado.");
	}

	public CanchaNoEncontradaException(String mensaje) {
		super(mensaje);
	}

	
	
}
