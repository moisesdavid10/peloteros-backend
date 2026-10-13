package com.empresa.peloteros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empresa.peloteros.entity.ComplejoDeportivo;

public interface IComplejoDeportivoRepository extends JpaRepository<ComplejoDeportivo, Long> {

	@Query(value = "SELECT * from complejo_deportivo WHERE nombre ILIKE '%' || :filtro || '%'", nativeQuery = true)
	List<ComplejoDeportivo> buscarPorNombre(@Param("filtro") String filtro);
}
