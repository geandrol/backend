package com.geandro.rastreador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geandro.rastreador.dto.PedidoCadastroDTO;
import com.geandro.rastreador.model.Pedido;
import com.geandro.rastreador.model.StatusPedido;
import com.geandro.rastreador.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	private final PedidoService service;

	public PedidoController(PedidoService service) {
		this.service = service;
	}

	/*
	 * Criar pedido
	 */
	@PostMapping("/cadastro")
	public ResponseEntity<Pedido> criar(@RequestBody PedidoCadastroDTO dto) {

		Pedido pedido = service.criarPedido(dto);

		return ResponseEntity.status(HttpStatus.CREATED).body(pedido);

	}

	/*
	 * Listar pedidos
	 */
	@GetMapping
	public ResponseEntity<List<Pedido>> listar() {

		return ResponseEntity.ok(service.listar());

	}

	/*
	 * Buscar por ID
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> buscar(@PathVariable Long id) {

		return ResponseEntity.ok(service.buscarPorId(id));

	}

	/*
	 * Atualizar status
	 */
	@PutMapping("/{id}/status")
	public ResponseEntity<Pedido> atualizarStatus(@PathVariable Long id, @RequestParam StatusPedido status) {

		Pedido pedido = service.atualizarStatus(id, status);

		return ResponseEntity.ok(pedido);

	}

}