package com.empresa.peloteros.dto;

import java.math.BigDecimal;

public class CanchaSinteticaResponse {

	private Long id;

	private String nombre;

	private Long deporteId;
	private String deporteNombre;

	private Integer capacidad;

	private BigDecimal precioHora;

	private Long complejoId;
	private String complejoNombre;

	private Boolean disponible;



	public CanchaSinteticaResponse(Long id, String nombre, Long deporteId, String deporteNombre, Integer capacidad,
			BigDecimal precioHora, Long complejoId, String complejoNombre, Boolean disponible) {
		this.id = id;
		this.nombre = nombre;
		this.deporteId = deporteId;
		this.deporteNombre = deporteNombre;
		this.capacidad = capacidad;
		this.precioHora = precioHora;
		this.complejoId = complejoId;
		this.complejoNombre = complejoNombre;
		this.disponible = disponible;
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

	public Long getDeporteId() {
		return deporteId;
	}

	public void setDeporteId(Long deporteId) {
		this.deporteId = deporteId;
	}

	public String getDeporteNombre() {
		return deporteNombre;
	}

	public void setDeporteNombre(String deporteNombre) {
		this.deporteNombre = deporteNombre;
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

	public Long getComplejoId() {
		return complejoId;
	}

	public void setComplejoId(Long complejoId) {
		this.complejoId = complejoId;
	}

	public String getComplejoNombre() {
		return complejoNombre;
	}

	public void setComplejoNombre(String complejoNombre) {
		this.complejoNombre = complejoNombre;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "CanchaSinteticaResponse [id=" + id + ", nombre=" + nombre + ", deporteId=" + deporteId
				+ ", deporteNombre=" + deporteNombre + ", capacidad=" + capacidad + ", precioHora=" + precioHora
				+ ", complejoId=" + complejoId + ", complejoNombre=" + complejoNombre + ", disponible=" + disponible
				+ "]";
	}

	
	
}
