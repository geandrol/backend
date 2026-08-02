package com.geandro.rastreador.service;

import org.springframework.stereotype.Service;
import com.geandro.rastreador.dto.ItemPedidoDTO;
import com.geandro.rastreador.model.ItemPedido;
import com.geandro.rastreador.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	private final ItemPedidoRepository repository;

	public ItemPedidoService(ItemPedidoRepository repository) {
		this.repository = repository;
	}

	public ItemPedido cadastrar(ItemPedidoDTO dto) {
	    ItemPedido item = new ItemPedido();
	    item.setProduto(dto.getProduto());
	    item.setPreco(dto.getPreco());
	    return repository.save(item);
	}
}