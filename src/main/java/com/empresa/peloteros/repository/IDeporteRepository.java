package com.empresa.peloteros.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.peloteros.entity.Deporte;

public interface IDeporteRepository extends JpaRepository<Deporte, Long> {
	Optional<Deporte> findByNombre(String nombre);

}
