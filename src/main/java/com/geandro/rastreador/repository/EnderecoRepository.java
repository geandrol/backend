package com.geandro.rastreador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geandro.rastreador.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}