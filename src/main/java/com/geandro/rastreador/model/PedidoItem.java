package com.geandro.rastreador.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido_itens")
public class PedidoItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "pedido_id")
	@JsonIgnore
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "item_pedido_id")
	@JsonUnwrapped
	@com.fasterxml.jackson.annotation.JsonIgnoreProperties("id")
	private ItemPedido item;

	private Integer quantidade;

	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }

	public Pedido getPedido() { return pedido; }
	public void setPedido(Pedido pedido) { this.pedido = pedido; }

	public ItemPedido getItem() { return item; }
	public void setItem(ItemPedido item) { this.item = item; }

	public Integer getQuantidade() { return quantidade; }
	public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }
}