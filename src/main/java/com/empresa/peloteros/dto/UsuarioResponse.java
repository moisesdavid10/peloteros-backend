package com.empresa.peloteros.dto;

import java.time.OffsetDateTime;

public class UsuarioResponse {

	private Long id;
	private String email;
	private String nombres;
	private String apellidos;
	private String telefono;
	private OffsetDateTime createdAt;
	private OffsetDateTime modifiedAt;

	public UsuarioResponse() {
	}

	public UsuarioResponse(Long id, String email, String nombres, String apellidos, String telefono,
			OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
		this.id = id;
		this.email = email;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Long getId() {
		return id;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefono() {
		return telefono;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public OffsetDateTime getModifiedAt() {
		return modifiedAt;
	}

	@Override
	public String toString() {
		return "UsuarioResponse [id=" + id + ", email=" + email + ", nombres=" + nombres + ", apellidos=" + apellidos
				+ ", telefono=" + telefono + ", createdAt=" + createdAt + ", modifiedAt=" + modifiedAt + "]";
	}

}
