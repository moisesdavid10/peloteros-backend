package com.empresa.peloteros.exception;

public class EmailDuplicadoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailDuplicadoException() {
		super("El email ya ha sido registrado.");
	}

	public EmailDuplicadoException(String mensaje) {
		super(mensaje);
	}

}
