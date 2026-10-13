package com.empresa.peloteros.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.peloteros.dto.AuthResponse;
import com.empresa.peloteros.dto.LoginRequest;
import com.empresa.peloteros.dto.UsuarioCreateRequest;
import com.empresa.peloteros.dto.UsuarioResponse;
import com.empresa.peloteros.service.AuthService;
import com.empresa.peloteros.service.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	private final UsuarioService usuarioService;
	private final AuthService authService;


	public AuthController(UsuarioService usuarioService, AuthService authService) {
		this.usuarioService = usuarioService;
		this.authService = authService;
	}


	// POST
	@PostMapping("/registrar")
	public ResponseEntity<UsuarioResponse> registrar(@RequestBody @Valid UsuarioCreateRequest request) {
		LOG.info("[AuthController - registrar] : request - {}", request);
        UsuarioResponse response = usuarioService.registrar(request);
		LOG.info("[AuthController - registrar] : response - {}", response);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
	
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody @Valid LoginRequest request){
		LOG.info("[AuthController - login] : request - {}", request);
		AuthResponse response = authService.login(request);
		LOG.info("[AuthController - login] : response - {}", response);
		return ResponseEntity.ok(response);
	}

}
