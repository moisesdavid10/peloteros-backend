package com.empresa.peloteros.exception;

public class HorarioInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public HorarioInvalidoException() {
		super("La hora final debe ser mayor a la hora de inicio.");
	}

	public HorarioInvalidoException(String mensaje) {
		super(mensaje);
	}

}
