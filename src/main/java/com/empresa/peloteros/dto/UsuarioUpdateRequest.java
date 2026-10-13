package com.empresa.peloteros.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioUpdateRequest {
	
	@NotBlank(message = "El email es obligatorio")
	@Email(message = "El formato del email no es valido")
	private String email;
	
	@NotBlank(message = "El nombre es obligatorio")
	private String nombres;
	
	@NotBlank(message = "Los apellidos son obligatorios")
	private String apellidos;
	
	@NotBlank(message = "El telefono es obligatorio")
	private String telefono;

	public UsuarioUpdateRequest() {
	}

	public UsuarioUpdateRequest(String email, String nombres, String apellidos, String telefono) {
		this.email = email;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
