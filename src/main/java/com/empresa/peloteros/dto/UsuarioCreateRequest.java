package com.empresa.peloteros.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCreateRequest {

	@NotBlank(message = "El email es obligatorio")
	@Email(message = "El formato del email no es valido")
	private String email;

	@NotBlank(message = "La contraseña es obligatoria")
	@Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
	private String password;

	@NotBlank(message = "El nombre es obligatorio")
	private String nombres;

	@NotBlank(message = "Los apellidos son obligatorios")
	private String apellidos;

	@NotBlank(message = "El telefono es obligatorio")
	private String telefono;

	public UsuarioCreateRequest() {
	}

	public UsuarioCreateRequest(String email, String password, String nombres, String apellidos, String telefono) {
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String toString() {
		return "UsuarioCreateRequest [email=" + email + ", password=" + password + ", nombres=" + nombres
				+ ", apellidos=" + apellidos + ", telefono=" + telefono + "]";
	}

}
