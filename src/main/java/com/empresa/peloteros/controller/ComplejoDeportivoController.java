package com.empresa.peloteros.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.peloteros.dto.ComplejoDeportivoRequest;
import com.empresa.peloteros.dto.ComplejoDeportivoResponse;
import com.empresa.peloteros.service.ComplejoDeportivoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/complejos")
public class ComplejoDeportivoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ComplejoDeportivoController.class);
	
	private final ComplejoDeportivoService complejoService;

	public ComplejoDeportivoController(ComplejoDeportivoService complejoService) {
		this.complejoService = complejoService;
	}

	
	// POST
	@PostMapping
	public ResponseEntity<ComplejoDeportivoResponse> registrar(@RequestBody @Valid ComplejoDeportivoRequest request){
		LOG.info("[ComplejoDeportivoController - registrar] : request - {}", request);

		ComplejoDeportivoResponse response = complejoService.registrar(request);
		LOG.info("[ComplejoDeportivoController - registrar] : response - {}", response);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	// GET
	@GetMapping
	public ResponseEntity<Page<ComplejoDeportivoResponse>> listar(@PageableDefault(page = 0, size = 20, sort = "id") Pageable pageable){
		Page<ComplejoDeportivoResponse> paginaComplejos = complejoService.listar(pageable);
		LOG.info("[ComplejoDeportivoController - listar] : Page - {}", paginaComplejos.getTotalElements());

		return ResponseEntity.ok(paginaComplejos);
	}
	
	
	// GET - {id}
	@GetMapping("/{id}")
	public ResponseEntity<ComplejoDeportivoResponse> buscarPorId(@PathVariable Long id){
		LOG.info("[ComplejoDeportivoController - buscarPorId] : id - {}", id);

		return complejoService.buscarPorId(id)
							.map(complejo -> ResponseEntity.ok(complejo))
							.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	

	//PUT - {id}
	@PutMapping("/{id}")
	public ResponseEntity<ComplejoDeportivoResponse> actualizar(@PathVariable Long id,
																@RequestBody @Valid ComplejoDeportivoRequest request){
		LOG.info("[ComplejoDeportivoController - actualizar] : id - {}, request - {}", id, request);

		ComplejoDeportivoResponse response = complejoService.actualizar(id, request);
		LOG.info("[ComplejoDeportivoController - actualizar] : response", response);

		return ResponseEntity.ok(response);
	}
	
	//DELETE - {id}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Long id){
		LOG.info("[ComplejoDeportivoController - eliminar] : id - {}", id);

		complejoService.eliminar(id);
		return ResponseEntity.noContent().build();
	}
	
}
