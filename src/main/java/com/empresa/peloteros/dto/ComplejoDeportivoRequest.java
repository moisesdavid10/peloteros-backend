package com.empresa.peloteros.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ComplejoDeportivoRequest {
	@NotBlank(message = "El nombre del complejo es obligatorio")
	@Size(max = 100, message = "El nombre no puede superar los 100 caracteres")
	private String nombre;
	
	@NotBlank(message = "La direccion es obligatoria")
	@Size(max = 255, message = "La direccion no puede superar los 255 caracteres")
	private String direccion;
	
	@Size(max = 50, message = "El telefono no puede superar los 50 caracteres")
	private String telefono;
	private BigDecimal latitud;
	private BigDecimal longitud;

	public ComplejoDeportivoRequest() {
	}

	public ComplejoDeportivoRequest(String nombre, String direccion, String telefono) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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

	@Override
	public String toString() {
		return "ComplejoDeportivoRequest [nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}
	

}
