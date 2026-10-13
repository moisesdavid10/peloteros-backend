package com.empresa.peloteros.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CanchaSinteticaCreateRequest {
	
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

	@NotNull(message = "El ID del complejo deportivo es obligatorio")
	private Long complejoId;

	public CanchaSinteticaCreateRequest() {
	}

	public CanchaSinteticaCreateRequest(String nombre, Long deporteId, Integer capacidad, BigDecimal precioHora,
			Long complejoId) {
		this.nombre = nombre;
		this.deporteId = deporteId;
		this.capacidad = capacidad;
		this.precioHora = precioHora;
		this.complejoId = complejoId;
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

	public Long getComplejoId() {
		return complejoId;
	}

	public void setComplejoId(Long complejoId) {
		this.complejoId = complejoId;
	}

	@Override
	public String toString() {
		return "CanchaSinteticaCreateRequest [nombre=" + nombre + ", deporteId=" + deporteId + ", capacidad="
				+ capacidad + ", precioHora=" + precioHora + ", complejoId=" + complejoId + "]";
	}

	
	
}
