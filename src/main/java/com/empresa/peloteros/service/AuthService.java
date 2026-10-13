package com.empresa.peloteros.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.empresa.peloteros.dto.AuthResponse;
import com.empresa.peloteros.dto.LoginRequest;
import com.empresa.peloteros.entity.Usuario;
import com.empresa.peloteros.exception.CredencialesInvalidasException;
import com.empresa.peloteros.exception.CuentaInactivaException;
import com.empresa.peloteros.repository.IUsuarioRepository;


@Service
public class AuthService {
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthService.class);
	private final IUsuarioRepository usuarioRepository;

	public AuthService(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}



	public AuthResponse login(LoginRequest request) {
		LOG.info("[AuthService - login] : {}", request);
		Usuario usuarioBuscado = usuarioRepository.findByEmail(request.getEmail())
													.orElseThrow(() -> {
															LOG.warn("[AuthService - login]: email no encontrado {}", request.getEmail());
															return new CredencialesInvalidasException();
														});
		
		if(usuarioBuscado.getActivo() == null || !usuarioBuscado.getActivo()) {
			LOG.warn("[AuthService - login] : cuenta inactiva {}", request.getEmail());
			throw new CuentaInactivaException();
		}
		if(!usuarioBuscado.getPassword().equals(request.getPassword())) {
			LOG.warn("[AuthService - login] : Contraseña incorrecta {}", request.getEmail());
			throw new CredencialesInvalidasException();
		}
		LOG.info("[AuthService - login] : Login exitoso para el usuario {}", usuarioBuscado.getFullName());
        return new AuthResponse("jwt-token-12345", "¡Bienvenido de nuevo, " + usuarioBuscado.getFullName() + "!");
    }
}
