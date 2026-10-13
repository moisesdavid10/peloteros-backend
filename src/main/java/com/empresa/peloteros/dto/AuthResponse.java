package com.empresa.peloteros.dto;

public class AuthResponse {

	private String token;
	private String mensaje;

	public AuthResponse(String token, String mensaje) {
		this.token = token;
		this.mensaje = mensaje;
	}

	public String getToken() {
		return token;
	}

	public String getMensaje() {
		return mensaje;
	}

	@Override
	public String toString() {
		return "AuthResponse [token=" + token + ", mensaje=" + mensaje + "]";
	}

}
