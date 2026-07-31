package com.geandro.rastreador.dto;


import java.time.LocalDateTime;
import java.util.List;

import com.geandro.rastreador.model.StatusPedido;

public class PedidoRespostaDTO {

	private Long id;

	private LocalDateTime dataPedido;

	private StatusPedido status;

	private UsuarioRespostaDTO cliente;

	private List<ItemPedidoDTO> itens;

	private EnderecoEntregaDTO enderecoEntrega;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public UsuarioRespostaDTO getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioRespostaDTO cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedidoDTO> itens) {
		this.itens = itens;
	}

	public EnderecoEntregaDTO getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntregaDTO enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	

}
