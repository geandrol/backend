package com.geandro.rastreador.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geandro.rastreador.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// Buscar usuário pelo email no login
	Optional<Usuario> findByEmail(String email);

	// Verificar se email já existe no cadastro
	boolean existsByEmail(String email);

}