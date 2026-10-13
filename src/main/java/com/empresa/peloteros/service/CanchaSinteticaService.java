package com.empresa.peloteros.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.peloteros.dto.CanchaSinteticaCreateRequest;
import com.empresa.peloteros.dto.CanchaSinteticaResponse;
import com.empresa.peloteros.dto.CanchaSinteticaUpdateRequest;
import com.empresa.peloteros.entity.CanchaSintetica;
import com.empresa.peloteros.entity.ComplejoDeportivo;
import com.empresa.peloteros.entity.Deporte;
import com.empresa.peloteros.exception.CanchaNoEncontradaException;
import com.empresa.peloteros.exception.ComplejoDeportivoNoEncontradoException;
import com.empresa.peloteros.exception.DeporteNoEncontradoException;
import com.empresa.peloteros.repository.ICanchaSinteticaRepository;
import com.empresa.peloteros.repository.IComplejoDeportivoRepository;
import com.empresa.peloteros.repository.IDeporteRepository;

@Service
@Transactional
public class CanchaSinteticaService {

	private final IComplejoDeportivoRepository complejoRepository;
	private final ICanchaSinteticaRepository canchaRepository;
	private final IDeporteRepository deporteRepository;


	public CanchaSinteticaService(IComplejoDeportivoRepository complejoRepository,
			ICanchaSinteticaRepository canchaRepository, IDeporteRepository deporteRepository) {
		this.complejoRepository = complejoRepository;
		this.canchaRepository = canchaRepository;
		this.deporteRepository = deporteRepository;
	}

	public CanchaSinteticaResponse registrar(CanchaSinteticaCreateRequest request) {
		Deporte deporteBuscado = deporteRepository.findById(request.getDeporteId())
													.orElseThrow(() -> new DeporteNoEncontradoException("El deporte con ID " + request.getDeporteId() + " no existe."));
		
		ComplejoDeportivo complejoBuscado = complejoRepository.findById(request.getComplejoId())
																.orElseThrow(() -> new ComplejoDeportivoNoEncontradoException("El complejo deportivo con ID " + request.getComplejoId() + " no existe."));
		
		CanchaSintetica entidad = toEntity(request, deporteBuscado, complejoBuscado);
		
		CanchaSintetica entidadGuardada = canchaRepository.save(entidad);
		return toResponse(entidadGuardada);
	}
	
	public CanchaSinteticaResponse actualizar (Long id, CanchaSinteticaUpdateRequest request) {
		CanchaSintetica canchaBuscada = canchaRepository.findById(id)
														.orElseThrow(()-> new CanchaNoEncontradaException("La cancha sintética con ID " + id + " no existe."));
		
		Deporte deporteBuscado = deporteRepository.findById(request.getDeporteId())
									.orElseThrow(()-> new DeporteNoEncontradoException("El deporte con ID " + request.getDeporteId() + " no existe."));
		
		canchaBuscada.actualizarDatos(
				request.getNombre(),
				request.getCapacidad(),
				request.getPrecioHora(),
				request.getDisponible(),
				deporteBuscado
				);
				
		CanchaSintetica entidadActualizada = canchaRepository.save(canchaBuscada);
		return toResponse(entidadActualizada);
	}
	
	
	@Transactional(readOnly = true)
	public Page<CanchaSinteticaResponse> listar(Pageable pageable) {
		Page<CanchaSintetica> paginaCanchas = canchaRepository.findByDisponibleTrue(pageable);
		return paginaCanchas.map(cancha -> toResponse(cancha));
	}
	
	@Transactional(readOnly = true)
	public Page<CanchaSinteticaResponse> listarAdmin(Pageable pageable) {
		Page<CanchaSintetica> paginaCanchas = canchaRepository.findAll(pageable);
		return paginaCanchas.map(cancha -> toResponse(cancha));
	}
	
	@Transactional(readOnly = true)
	public List<CanchaSinteticaResponse> listarPorComplejoId(Long complejoId){
		List<CanchaSintetica> canchas = canchaRepository.findByComplejoDeportivoIdAndDisponibleTrue(complejoId);
		return canchas.stream()
					.map(cancha -> toResponse(cancha))
					.collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<CanchaSinteticaResponse> listarPorComplejoIdAdmin(Long complejoId){
		List<CanchaSintetica> canchas = canchaRepository.findByComplejoDeportivoId(complejoId);
		return canchas.stream()
					.map(cancha -> toResponse(cancha))
					.collect(Collectors.toList());
	}
	
	
	@Transactional(readOnly = true)
	public Optional<CanchaSinteticaResponse> buscarPorId(Long id) {
		return canchaRepository.findByIdAndDisponibleTrue(id)
				.map(cancha -> toResponse(cancha));
	}
	
	@Transactional(readOnly = true)
	public Optional<CanchaSinteticaResponse> buscarPorIdAdmin(Long id) {
		return canchaRepository.findById(id)
				.map(cancha -> toResponse(cancha));
	}
	
	public void desactivar(Long id) {
		CanchaSintetica canchaBuscada = canchaRepository.findById(id)
				.orElseThrow(() -> new CanchaNoEncontradaException("La cancha sintética con ID " + id + " no existe."));
		
		canchaBuscada.desactivar(); 
		canchaRepository.save(canchaBuscada);
	}
	
	
	
	
	private CanchaSintetica toEntity(CanchaSinteticaCreateRequest canchaRequest, Deporte deporte, ComplejoDeportivo complejoDeportivo) {
		CanchaSintetica entidad = new CanchaSintetica();
		entidad.setNombre(canchaRequest.getNombre());
		entidad.setCapacidad(canchaRequest.getCapacidad());
		entidad.setPrecioHora(canchaRequest.getPrecioHora());
		entidad.setDeporte(deporte);
		entidad.setComplejoDeportivo(complejoDeportivo);
		return entidad;
	}
	
	
	private CanchaSinteticaResponse toResponse(CanchaSintetica canchaEntity) {
		return new CanchaSinteticaResponse(
				canchaEntity.getId(), 
				canchaEntity.getNombre(),
				canchaEntity.getDeporte() != null ? canchaEntity.getDeporte().getId() : null,
				canchaEntity.getDeporte() != null ? canchaEntity.getDeporte().getNombre() : null,
				canchaEntity.getCapacidad(), 
				canchaEntity.getPrecioHora(),
				canchaEntity.getComplejoDeportivo() != null ? canchaEntity.getComplejoDeportivo().getId() : null,
				canchaEntity.getComplejoDeportivo() != null ? canchaEntity.getComplejoDeportivo().getNombre() : null,
				canchaEntity.getDisponible());
	}
	
	
}
