package com.empresa.peloteros.exception;

public class CuentaInactivaException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CuentaInactivaException() {
		super("Tu cuenta se encuentra desactivada");
	}

	public CuentaInactivaException(String mensaje) {
		super(mensaje);
	}
}
