package com.geandro.rastreador.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geandro.rastreador.dto.UsuarioCadastroDTO;
import com.geandro.rastreador.dto.UsuarioLoginDTO;
import com.geandro.rastreador.model.Usuario;
import com.geandro.rastreador.repository.UsuarioRepository;


@Service
public class UsuarioService {

	private final UsuarioRepository repository;

	private final PasswordEncoder passwordEncoder;

	public UsuarioService(UsuarioRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}

	/*
	 * Cadastro de usuário
	 */
	public Usuario cadastrar(UsuarioCadastroDTO dto) {

		if (repository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("E-mail já cadastrado");
		}

		Usuario usuario = new Usuario();

		usuario.setNome(dto.getNome());

		usuario.setEmail(dto.getEmail());

		// Criptografa senha
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));

		return repository.save(usuario);

	}

	/*
	 * Login
	 */
	public Usuario login(UsuarioLoginDTO dto) {

		Usuario usuario = repository.findByEmail(dto.getEmail())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {

			throw new RuntimeException("Senha inválida");

		}

		return usuario;

	}
	

}