package com.empresa.peloteros.exception;

public class UsuarioNoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public UsuarioNoEncontradoException() {
        super("Usuario no econtrado.");
    }
	
	public UsuarioNoEncontradoException(String mensaje) {
		super(mensaje);
    }

}
