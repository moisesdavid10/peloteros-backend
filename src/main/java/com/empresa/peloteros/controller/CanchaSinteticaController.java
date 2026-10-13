package com.empresa.peloteros.controller;

import java.util.List;

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

import com.empresa.peloteros.dto.CanchaSinteticaCreateRequest;
import com.empresa.peloteros.dto.CanchaSinteticaResponse;
import com.empresa.peloteros.dto.CanchaSinteticaUpdateRequest;
import com.empresa.peloteros.service.CanchaSinteticaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/canchas")
public class CanchaSinteticaController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CanchaSinteticaController.class);
	
	private final CanchaSinteticaService canchaService;

	public CanchaSinteticaController(CanchaSinteticaService canchaService) {
		this.canchaService = canchaService;
	}
	
	// POST
	@PostMapping
	public ResponseEntity<CanchaSinteticaResponse> registrar(@RequestBody @Valid CanchaSinteticaCreateRequest request) {
		LOG.info("[CanchaSinteticaController - registrar] : request - {}", request);
		CanchaSinteticaResponse response = canchaService.registrar(request);
		
		LOG.info("[CanchaSinteticaController - registrar] : response - {}", response);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);	
	}
	
	// GET
	@GetMapping
	public ResponseEntity<Page<CanchaSinteticaResponse>> listar(@PageableDefault(page = 0, size = 20, sort = "id") Pageable pageable) {
		Page<CanchaSinteticaResponse> paginaCanchas = canchaService.listar(pageable);
		LOG.info("[CanchaSinteticaController - listar] : Page - {}", paginaCanchas.getTotalElements());
		return ResponseEntity.ok(paginaCanchas);
	}
	
	@GetMapping("/admin")
	public ResponseEntity<Page<CanchaSinteticaResponse>> listarAdmin(@PageableDefault(page = 0, size = 20, sort = "id") Pageable pageable) {
		Page<CanchaSinteticaResponse> paginaCanchas = canchaService.listarAdmin(pageable);
		LOG.info("[CanchaSinteticaController - listarAdmin] : Page - {}", paginaCanchas.getTotalElements());
		return ResponseEntity.ok(paginaCanchas);
	}
	
	@GetMapping("/complejo/{complejoId}")
	public ResponseEntity<List<CanchaSinteticaResponse>> listarPorComplejoId(@PathVariable Long complejoId) {
		LOG.info("[CanchaSinteticaController - listarPorComplejoId] : complejoId - {}", complejoId);

		List<CanchaSinteticaResponse> canchas = canchaService.listarPorComplejoId(complejoId);
		LOG.info("[CanchaSinteticaController - listarPorComplejoId] : List - {}", canchas);

		return ResponseEntity.ok(canchas);
	}
	
	@GetMapping("/complejo/{complejoId}/admin")
	public ResponseEntity<List<CanchaSinteticaResponse>> listarPorComplejoIdAdmin(@PathVariable Long complejoId) {
		LOG.info("[CanchaSinteticaController - listarPorComplejoIdAdmin] : complejoId - {}", complejoId);

		List<CanchaSinteticaResponse> canchas = canchaService.listarPorComplejoIdAdmin(complejoId);
		LOG.info("[CanchaSinteticaController - listarPorComplejoIdAdmin] : List - {}", canchas);

		return ResponseEntity.ok(canchas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CanchaSinteticaResponse> buscarPorId(@PathVariable Long id) {
		LOG.info("[CanchaSinteticaController - buscarPorId] : id - {}", id);

		return canchaService.buscarPorId(id)
						.map(cancha -> ResponseEntity.ok(cancha))
						.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	@GetMapping("/{id}/admin")
	public ResponseEntity<CanchaSinteticaResponse> buscarPorIdAdmin(@PathVariable Long id) {
		LOG.info("[CanchaSinteticaController - buscarPorIdAdmin] : id - {}", id);

		return canchaService.buscarPorIdAdmin(id)
						.map(cancha -> ResponseEntity.ok(cancha))
						.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	
	//PUT - {id}
	@PutMapping("/{id}")
	public ResponseEntity<CanchaSinteticaResponse> actualizar(@PathVariable Long id,
														@RequestBody @Valid CanchaSinteticaUpdateRequest request){
		LOG.info("[CanchaSinteticaController - actualizar] : id - {}, request- {}", id, request);

		CanchaSinteticaResponse response = canchaService.actualizar(id, request);
		LOG.info("[CanchaSinteticaController - actualizar] : response - {}", response);

		return ResponseEntity.ok(response);
	}

	// DELETE - {id} borrado logico
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> desactivar(@PathVariable Long id) {
		LOG.info("[CanchaSinteticaController - desactivar] : id - {} ", id);

		canchaService.desactivar(id);
		return ResponseEntity.noContent().build();
	}

}
