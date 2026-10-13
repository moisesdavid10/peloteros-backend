package com.empresa.peloteros.exception;

public class DeporteNoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DeporteNoEncontradoException() {
		super("El deporte no se ha encontrado.");
	}

	public DeporteNoEncontradoException(String mensaje) {
		super(mensaje);
	}
}
