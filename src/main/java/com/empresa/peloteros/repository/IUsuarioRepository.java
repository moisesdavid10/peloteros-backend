package com.empresa.peloteros.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.empresa.peloteros.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

	boolean existsByEmail(String email);

	Optional<Usuario> findByIdAndActivoTrue(Long id);

	Page<Usuario> findByActivoTrue(Pageable pageable);

	Optional<Usuario> findByEmailAndActivoTrue(String email);

}
