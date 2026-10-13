package com.empresa.peloteros.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "complejo_deportivo")
public class ComplejoDeportivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@Column(nullable = false, length = 255)
	private String direccion;

	@Column(length = 50)
	private String telefono;

	@Column(precision = 10, scale = 8)
	private BigDecimal latitud;

	@Column(precision = 11, scale = 8)
	private BigDecimal longitud;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at", nullable = false)
	private OffsetDateTime modifiedAt;

	public ComplejoDeportivo() {
	}

	public ComplejoDeportivo(String nombre, String direccion, String telefono, BigDecimal latitud,
			BigDecimal longitud) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public void actualizarDatos(String nombre, String direccion, String telefono, BigDecimal latitud,
			BigDecimal longitud) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getLatitud() {
		return latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public OffsetDateTime getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(OffsetDateTime modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

}
