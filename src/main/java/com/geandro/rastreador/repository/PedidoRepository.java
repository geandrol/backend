package com.geandro.rastreador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geandro.rastreador.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}