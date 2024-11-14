package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Pedido;


public interface PedidoRepository extends JpaRepository <Pedido, Long>  {}
