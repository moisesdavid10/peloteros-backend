package com.empresa.peloteros.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CanchaSinteticaUpdateRequest {
	@NotBlank(message = "El nombre de la cancha es obligatorio")
	@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
	private String nombre;

	@NotNull(message = "El Id del deporte es obligatorio")
	private Long deporteId;

	@NotNull(message = "La capacidad es obligatoria")
	@Min(value = 1, message = "La capacidad debe ser al menos 1")
	private Integer capacidad;

	@NotNull(message = "El precio por hora es obligatorio")
	@DecimalMin(value = "0.0", inclusive = true, message = "El precio por hora no puede ser negativo")
	private BigDecimal precioHora;

	@NotNull(message = "El estado de disponibilidad es obligatorio")
	private Boolean disponible;

	public CanchaSinteticaUpdateRequest() {
	}

	public CanchaSinteticaUpdateRequest(String nombre, Long deporteId, Integer capacidad, BigDecimal precioHora,
			Boolean disponible) {
		this.nombre = nombre;
		this.deporteId = deporteId;
		this.capacidad = capacidad;
		this.precioHora = precioHora;
		this.disponible = disponible;
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

}
