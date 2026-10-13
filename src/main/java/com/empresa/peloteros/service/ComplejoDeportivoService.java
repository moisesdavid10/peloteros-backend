package com.empresa.peloteros.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.peloteros.dto.ComplejoDeportivoRequest;
import com.empresa.peloteros.dto.ComplejoDeportivoResponse;
import com.empresa.peloteros.entity.ComplejoDeportivo;
import com.empresa.peloteros.exception.ComplejoDeportivoNoEncontradoException;
import com.empresa.peloteros.repository.IComplejoDeportivoRepository;

@Service
@Transactional
public class ComplejoDeportivoService {
	
	private final IComplejoDeportivoRepository complejoRepository;

	public ComplejoDeportivoService(IComplejoDeportivoRepository complejoRepository) {
		this.complejoRepository = complejoRepository;
	}
	
	public ComplejoDeportivoResponse registrar(ComplejoDeportivoRequest request) {
		ComplejoDeportivo entidad = toEntity(request);
		ComplejoDeportivo entidadGuardada = complejoRepository.save(entidad);
		
		return toResponse(entidadGuardada);
	}
	
	@Transactional(readOnly = true)
	public Page<ComplejoDeportivoResponse> listar(Pageable pageable){
		Page<ComplejoDeportivo> paginaComplejos = complejoRepository.findAll(pageable);
		return paginaComplejos.map(complejo -> toResponse(complejo));
	}
	
	@Transactional(readOnly = true)
	public Optional<ComplejoDeportivoResponse> buscarPorId(Long id){
		return complejoRepository.findById(id)
				.map(complejo -> toResponse(complejo));
	}
	

	public ComplejoDeportivoResponse actualizar(Long id, ComplejoDeportivoRequest request) {
		ComplejoDeportivo complejoBuscado = complejoRepository.findById(id)
				.orElseThrow(() ->new ComplejoDeportivoNoEncontradoException("Complejo deportivo con ID: "+ id + " no existe."));
		
		complejoBuscado.actualizarDatos(
				request.getNombre(),
				request.getDireccion(),
				request.getTelefono(),
				request.getLatitud(),
				request.getLongitud()
				);
		
		ComplejoDeportivo entidadActualizada = complejoRepository.save(complejoBuscado);
		
		return toResponse(entidadActualizada);
	}
	
	public void eliminar(Long id) {
		if(!complejoRepository.existsById(id)){
			throw new ComplejoDeportivoNoEncontradoException("Complejo deportivo con ID: "+ id + "no existe.");
		}
		complejoRepository.deleteById(id);
	}
	
	
	private ComplejoDeportivo toEntity(ComplejoDeportivoRequest complejoRequest) {
		ComplejoDeportivo entidad = new ComplejoDeportivo();
		entidad.setNombre(complejoRequest.getNombre());
		entidad.setDireccion(complejoRequest.getDireccion());
		entidad.setTelefono(complejoRequest.getTelefono());
		entidad.setLatitud(complejoRequest.getLatitud());
		entidad.setLongitud(complejoRequest.getLongitud());
		return entidad;
	}
	
	private ComplejoDeportivoResponse toResponse(ComplejoDeportivo complejoEntity) {
		return new ComplejoDeportivoResponse(complejoEntity.getId(),
				complejoEntity.getNombre(),
				complejoEntity.getDireccion(),
				complejoEntity.getTelefono(),
				complejoEntity.getLatitud(),
				complejoEntity.getLongitud(),
				complejoEntity.getCreatedAt(),
				complejoEntity.getModifiedAt());
	}

}
