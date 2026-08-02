package com.geandro.rastreador.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geandro.rastreador.dto.ItemPedidoDTO;
import com.geandro.rastreador.model.ItemPedido;
import com.geandro.rastreador.repository.ItemPedidoRepository;
import com.geandro.rastreador.service.ItemPedidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

	private final ItemPedidoRepository repository;
	private final ItemPedidoService service;

	public ItemPedidoController(ItemPedidoRepository repository, ItemPedidoService service) {
		this.repository = repository;
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> listar() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@PostMapping
	public ResponseEntity<ItemPedido> cadastrar(@RequestBody ItemPedidoDTO dto) {
		ItemPedido item = service.cadastrar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(item);
	}
			
}