package com.geandro.rastreador.dto;

import java.util.List;

public class PedidoCadastroDTO {

	/*
	 * Cliente que realizou pedido
	 */
	private Long clienteId;

	/*
	 * Produtos
	 */
	private List<Long> itensIds;

	/*
	 * Local entrega
	 */
	private EnderecoEntregaDTO enderecoEntrega;

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public List<Long> getItensIds() {
		return itensIds;
	}

	public void setItensIds(List<Long> itensIds) {
		this.itensIds = itensIds;
	}

	public EnderecoEntregaDTO getEnderecoEntrega() {
		return enderecoEntrega;
	}

	public void setEnderecoEntrega(EnderecoEntregaDTO enderecoEntrega) {
		this.enderecoEntrega = enderecoEntrega;
	}
	
	

}