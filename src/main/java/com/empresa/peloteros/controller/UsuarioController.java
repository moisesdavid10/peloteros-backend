package com.empresa.peloteros.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.peloteros.dto.UsuarioResponse;
import com.empresa.peloteros.dto.UsuarioUpdateRequest;
import com.empresa.peloteros.service.UsuarioService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
	
	private final UsuarioService usuarioService;

   
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}


	// GET
	@GetMapping
	public ResponseEntity<Page<UsuarioResponse>> listar(@PageableDefault(page = 0, size = 20, sort ="id") Pageable pageable) {
		Page<UsuarioResponse> paginaUsuarios = usuarioService.listar(pageable);
		return ResponseEntity.ok(paginaUsuarios);
	}

	// GET - {id}
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Long id){
		return usuarioService.buscarPorId(id)
							.map(usuario -> ResponseEntity.ok(usuario))
							.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	// GET by EMAIL
	@GetMapping("/buscar")
	public ResponseEntity<UsuarioResponse> buscarPorEmail(@RequestParam String email){
		return usuarioService.buscarPorEmail(email)
								.map(usuario -> ResponseEntity.ok(usuario))
								.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}
	
	//PUT - {id}
	@PutMapping("/{id}")
	public ResponseEntity<UsuarioResponse> actualizar(@PathVariable Long id,
														@RequestBody @Valid UsuarioUpdateRequest request){
		UsuarioResponse response = usuarioService.actualizar(id, request);
		return ResponseEntity.ok(response);
	}
	
	//DELETE - {id} borrado logico
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> desactivar(@PathVariable Long id){
		usuarioService.desactivar(id);
		return ResponseEntity.noContent().build();
	}

}
