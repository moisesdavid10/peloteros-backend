package com.empresa.peloteros.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.empresa.peloteros.entity.CanchaSintetica;

public interface ICanchaSinteticaRepository extends JpaRepository<CanchaSintetica, Long>{

	List<CanchaSintetica> findByComplejoDeportivoId(Long complejoId);
	
	List<CanchaSintetica> findByComplejoDeportivoIdAndDisponibleTrue(Long complejoId);
	
	Optional<CanchaSintetica> findByIdAndDisponibleTrue(Long id);
	
	Page<CanchaSintetica> findByDeporteId(Long deporteId, Pageable pageable);
	
	Page<CanchaSintetica> findByDisponibleTrue(Pageable pageable);
}
