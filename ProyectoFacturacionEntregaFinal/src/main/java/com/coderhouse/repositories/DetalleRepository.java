package com.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.models.Detalle;


public interface DetalleRepository extends JpaRepository <Detalle, Long>  {}
