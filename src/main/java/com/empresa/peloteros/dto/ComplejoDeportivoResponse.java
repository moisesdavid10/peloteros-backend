package com.empresa.peloteros.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class ComplejoDeportivoResponse {

	private Long id;
	private String nombre;
	private String direccion;
	private String telefono;
	private BigDecimal latitud;
	private BigDecimal longitud;
	private OffsetDateTime createdAt;
	private OffsetDateTime modifiedAt;

	public ComplejoDeportivoResponse(Long id, String nombre, String direccion, String telefono, BigDecimal latitud,
			BigDecimal longitud, OffsetDateTime createdAt, OffsetDateTime modifiedAt) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public OffsetDateTime getModifiedAt() {
		return modifiedAt;
	}

	@Override
	public String toString() {
		return "ComplejoDeportivoResponse [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + ", latitud=" + latitud + ", longitud=" + longitud + ", createdAt=" + createdAt
				+ ", modifiedAt=" + modifiedAt + "]";
	}
	
	

}
