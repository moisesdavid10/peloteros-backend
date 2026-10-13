package com.empresa.peloteros.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cancha_sintetica")
public class CanchaSintetica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100)
	private String nombre;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deporte_id", nullable = false)
	private Deporte deporte;

	@Column(nullable = false)
	private Integer capacidad;

	@Column(name = "precio_hora", nullable = false, precision = 10, scale = 2)
	private BigDecimal precioHora;

	@Column(nullable = false)
	private Boolean disponible = true;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "complejo_id", nullable = false)
	private ComplejoDeportivo complejoDeportivo;

	@CreationTimestamp
	@Column(name = "created_at", nullable = false, updatable = false)
	private OffsetDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at", nullable = false)
	private OffsetDateTime modifiedAt;

	public CanchaSintetica() {
	}

	public CanchaSintetica(String nombre, Deporte deporte, Integer capacidad, BigDecimal precioHora,
			ComplejoDeportivo complejoDeportivo) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.capacidad = capacidad;
		this.precioHora = precioHora;
		this.complejoDeportivo = complejoDeportivo;
	}

	public void actualizarDatos(String nombre, Integer capacidad, BigDecimal precioHora, Boolean disponible,
			Deporte deporte) {
		this.nombre = nombre;
		this.deporte = deporte;
		this.capacidad = capacidad;
		this.precioHora = precioHora;
		this.disponible = disponible;
	}
	
	public void desactivar() {
		this.disponible = false;
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

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public BigDecimal getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(BigDecimal precioHora) {
		this.precioHora = precioHora;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public ComplejoDeportivo getComplejoDeportivo() {
		return complejoDeportivo;
	}

	public void setComplejoDeportivo(ComplejoDeportivo complejoDeportivo) {
		this.complejoDeportivo = complejoDeportivo;
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
