package com.geandro.rastreador.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.geandro.rastreador.model.ItemPedido;
import com.geandro.rastreador.repository.ItemPedidoRepository;

@RestController
@RequestMapping("/itens")
public class ItemPedidoController {

	private final ItemPedidoRepository repository;

	public ItemPedidoController(ItemPedidoRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> listar() {
		return ResponseEntity.ok(repository.findAll());
	}
}