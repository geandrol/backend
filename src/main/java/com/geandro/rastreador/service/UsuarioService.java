package com.geandro.rastreador.service;

import java.util.List;
import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.geandro.rastreador.dto.ClienteCadastroDTO;
import com.geandro.rastreador.dto.UsuarioCadastroDTO;
import com.geandro.rastreador.dto.UsuarioLoginDTO;
import com.geandro.rastreador.dto.UsuarioRespostaDTO;
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

	public Usuario cadastrar(UsuarioCadastroDTO dto) {
		if (repository.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("E-mail já cadastrado");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail(dto.getEmail());
		usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
		return repository.save(usuario);
	}

	public Usuario login(UsuarioLoginDTO dto) {
		Usuario usuario = repository.findByEmail(dto.getEmail())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
		if (!passwordEncoder.matches(dto.getSenha(), usuario.getSenha())) {
			throw new RuntimeException("Senha inválida");
		}
		return usuario;
	}

	public List<UsuarioRespostaDTO> listar() {
		return repository.findAll()
				.stream()
				.map(usuario -> {
					UsuarioRespostaDTO dto = new UsuarioRespostaDTO();
					dto.setId(usuario.getId());
					dto.setNome(usuario.getNome());
					dto.setEmail(usuario.getEmail());
					return dto;
				})
				.toList();
	}

	/*
	 * Cadastro rápido de cliente (sem login) — usado ao criar pedido
	 */
	public Usuario cadastrarCliente(ClienteCadastroDTO dto) {
		Usuario usuario = new Usuario();
		usuario.setNome(dto.getNome());
		usuario.setEmail("cliente-" + UUID.randomUUID() + "@sememail.local");
		usuario.setSenha(passwordEncoder.encode(UUID.randomUUID().toString()));
		return repository.save(usuario);
	}
}