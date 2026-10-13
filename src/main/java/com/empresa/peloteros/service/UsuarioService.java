package com.empresa.peloteros.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.peloteros.dto.UsuarioCreateRequest;
import com.empresa.peloteros.dto.UsuarioResponse;
import com.empresa.peloteros.dto.UsuarioUpdateRequest;
import com.empresa.peloteros.entity.Rol;
import com.empresa.peloteros.entity.Usuario;
import com.empresa.peloteros.exception.EmailDuplicadoException;
import com.empresa.peloteros.exception.RolNoEncontradoException;
import com.empresa.peloteros.exception.UsuarioNoEncontradoException;
import com.empresa.peloteros.repository.IRolRepository;
import com.empresa.peloteros.repository.IUsuarioRepository;
import com.empresa.peloteros.util.RolConstantes;


@Service
@Transactional
public class UsuarioService {

	private final IUsuarioRepository usuarioRepository;
	private final IRolRepository rolRepository;

	public UsuarioService(IUsuarioRepository usuarioRepository, IRolRepository rolRepository) {
		this.usuarioRepository = usuarioRepository;
		this.rolRepository = rolRepository;
	}
	
	public UsuarioResponse registrar(UsuarioCreateRequest request) {
		if (usuarioRepository.existsByEmail(request.getEmail())) {
			throw new EmailDuplicadoException("El email " + request.getEmail() + " ya se encuentra registrado.");
		}

		Rol rolCliente = rolRepository.findByNombre(RolConstantes.CLIENTE)
				.orElseThrow(() -> new RolNoEncontradoException(
						"El rol " + RolConstantes.CLIENTE + ", no existe en la base de datos."));

		Usuario entidad = toEntity(request);
		entidad.agregaRol(rolCliente);

		Usuario entidadGuardada = usuarioRepository.save(entidad);
		return toResponse(entidadGuardada);
	}

	public UsuarioResponse actualizar(Long id, UsuarioUpdateRequest request) {
		Usuario usuarioBuscado = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNoEncontradoException("El usuario con ID " + id + " no existe."));

		if (!usuarioBuscado.getEmail().equalsIgnoreCase(request.getEmail())) {
			if (usuarioRepository.existsByEmail(request.getEmail())) {
				throw new EmailDuplicadoException("El email " + request.getEmail() + " ya se encuentra registrado.");
			}
		}

		usuarioBuscado.actualizarDatos(
	            request.getEmail(), 
	            request.getNombres(), 
	            request.getApellidos(), 
	            request.getTelefono()
	    );
		
		Usuario entidadActualizada = usuarioRepository.save(usuarioBuscado);

		return toResponse(entidadActualizada);
	}

	@Transactional(readOnly = true)
	public Page<UsuarioResponse> listar(Pageable pageable) {
		Page<Usuario> paginaUsuarios = usuarioRepository.findByActivoTrue(pageable);
		return paginaUsuarios.map(jugador -> toResponse(jugador));
	}
	
	@Transactional(readOnly = true)
	public Page<UsuarioResponse> listarAdmin(Pageable pageable) {
		Page<Usuario> paginaUsuarios = usuarioRepository.findAll(pageable);
		return paginaUsuarios.map(jugador -> toResponse(jugador));
	}

	@Transactional(readOnly = true)
	public Optional<UsuarioResponse> buscarPorId(Long id) {
		return usuarioRepository.findByIdAndActivoTrue(id)
				.map(jugador -> toResponse(jugador));
	}

	@Transactional(readOnly = true)
	public Optional<UsuarioResponse> buscarPorEmail(String email) {
		return usuarioRepository.findByEmailAndActivoTrue(email)
				.map(jugador -> toResponse(jugador));
	}

	public void desactivar(Long id) {
		Usuario usuarioBuscado = usuarioRepository.findById(id)
				.orElseThrow(() -> new UsuarioNoEncontradoException("El usuario con ID " + id + " no existe."));

		usuarioBuscado.desactivar();
		usuarioRepository.save(usuarioBuscado);
	}

	private Usuario toEntity(UsuarioCreateRequest usuarioRequest) {
		Usuario entidad = new Usuario();
		entidad.setEmail(usuarioRequest.getEmail());
		entidad.setPassword(usuarioRequest.getPassword());
		entidad.setNombres(usuarioRequest.getNombres());
		entidad.setApellidos(usuarioRequest.getApellidos());
		entidad.setTelefono(usuarioRequest.getTelefono());
		return entidad;
	}

	private UsuarioResponse toResponse(Usuario usuarioEntity) {
		return new UsuarioResponse(usuarioEntity.getId(), 
				usuarioEntity.getEmail(), 
				usuarioEntity.getNombres(),
				usuarioEntity.getApellidos(), 
				usuarioEntity.getTelefono(), 
				usuarioEntity.getCreatedAt(),
				usuarioEntity.getModifiedAt());
	}

}