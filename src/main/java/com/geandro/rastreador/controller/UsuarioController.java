package com.geandro.rastreador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geandro.rastreador.dto.ClienteCadastroDTO;
import com.geandro.rastreador.dto.LoginResponseDTO;
import com.geandro.rastreador.dto.UsuarioCadastroDTO;
import com.geandro.rastreador.dto.UsuarioLoginDTO;
import com.geandro.rastreador.dto.UsuarioRespostaDTO;
import com.geandro.rastreador.model.Usuario;
import com.geandro.rastreador.service.JwtService;
import com.geandro.rastreador.service.UsuarioService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*")
@Tag(name = "usuarios", description = "Gerenciamento de pedidos")
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService service;
	private final JwtService jwtService;

	public UsuarioController(UsuarioService service, JwtService jwtService) {
		this.service = service;
		this.jwtService = jwtService;
	}

	/*
	 * Cadastro usuário
	 */
	@PostMapping("/cadastro")
	public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioCadastroDTO dto) {

		Usuario usuario = service.cadastrar(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

	}

	/*
	 * Login
	 */
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody UsuarioLoginDTO dto) {

		Usuario usuario = service.login(dto);

		String token = jwtService.gerarToken(usuario.getEmail());

		return ResponseEntity.ok(new LoginResponseDTO(token));
	}
	
	@PostMapping("/clientes")
	public ResponseEntity<UsuarioRespostaDTO> cadastrarCliente(@RequestBody ClienteCadastroDTO dto) {

		Usuario usuario = service.cadastrarCliente(dto);

		UsuarioRespostaDTO resposta = new UsuarioRespostaDTO();
		resposta.setId(usuario.getId());
		resposta.setNome(usuario.getNome());
		resposta.setEmail(usuario.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioRespostaDTO>> listar() {

		return ResponseEntity.ok(service.listar());

	}

}