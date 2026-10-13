package com.empresa.peloteros.exception;

public class CredencialesInvalidasException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CredencialesInvalidasException() {
		super("Email o password incorrectos");
	}
	
	public CredencialesInvalidasException(String mensaje) {
		super(mensaje);
	}
	

}
