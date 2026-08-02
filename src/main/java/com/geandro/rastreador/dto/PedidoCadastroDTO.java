package com.geandro.rastreador.dto;

import java.util.List;

public class PedidoCadastroDTO {

	private Long clienteId;
	private List<ItemQuantidadeDTO> itens;
	private EnderecoEntregaDTO enderecoEntrega;

	public Long getClienteId() { return clienteId; }
	public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

	public List<ItemQuantidadeDTO> getItens() { return itens; }
	public void setItens(List<ItemQuantidadeDTO> itens) { this.itens = itens; }

	public EnderecoEntregaDTO getEnderecoEntrega() { return enderecoEntrega; }
	public void setEnderecoEntrega(EnderecoEntregaDTO enderecoEntrega) { this.enderecoEntrega = enderecoEntrega; }
}