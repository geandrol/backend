package com.geandro.rastreador.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.geandro.rastreador.dto.PedidoCadastroDTO;
import com.geandro.rastreador.model.*;
import com.geandro.rastreador.repository.*;

@Service
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	private final UsuarioRepository usuarioRepository;
	
	private final ItemPedidoRepository itemPedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository, UsuarioRepository usuarioRepository, ItemPedidoRepository itemPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.usuarioRepository = usuarioRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}

	/*
	 * Criar pedido
	 */
	public Pedido criarPedido(PedidoCadastroDTO dto) {

	    Usuario cliente = usuarioRepository.findById(dto.getClienteId())
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	    Pedido pedido = new Pedido();

	    pedido.setCliente(cliente);
	    pedido.setDataPedido(LocalDateTime.now());
	    pedido.setStatus(StatusPedido.RECEBIDO);

	    // endereço
	    Endereco endereco = new Endereco();
	    endereco.setRua(dto.getEnderecoEntrega().getRua());
	    endereco.setNumero(dto.getEnderecoEntrega().getNumero());
	    endereco.setBairro(dto.getEnderecoEntrega().getBairro());
	    endereco.setCidade(dto.getEnderecoEntrega().getCidade());
	    endereco.setComplemento(dto.getEnderecoEntrega().getComplemento());
	    pedido.setEndereco(endereco);

	    // busca os itens já cadastrados pelo ID
	    List<ItemPedido> itens = itemPedidoRepository.findAllById(dto.getItensIds());

	    if (itens.size() != dto.getItensIds().size()) {
	        throw new RuntimeException("Um ou mais itens informados não foram encontrados");
	    }

	    // vincula cada item ao pedido
	    itens.forEach(item -> item.setPedido(pedido));

	    pedido.setItens(itens);

	    return pedidoRepository.save(pedido);
	}

	/*
	 * Listar todos pedidos
	 */
	public List<Pedido> listar() {

		return pedidoRepository.findAll();

	}

	/*
	 * Buscar pedido por ID
	 */
	public Pedido buscarPorId(Long id) {

		return pedidoRepository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

	}

	/*
	 * Atualizar status
	 */
	public Pedido atualizarStatus(Long id, StatusPedido status) {

		Pedido pedido = buscarPorId(id);

		pedido.setStatus(status);

		return pedidoRepository.save(pedido);

	}

}
