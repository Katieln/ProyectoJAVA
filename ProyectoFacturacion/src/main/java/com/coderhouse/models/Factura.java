package com.coderhouse.models;

import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Factura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

	@Column(name = "cliente_id", nullable = false) // Relación con el cliente (no puede ser nulo)
    private Long clienteId;

    @Temporal(TemporalType.DATE) // Tipo de dato para la fecha
    @Column(nullable = false) // No puede ser nulo
    private Date fecha;

    @Column(nullable = false) // Total de la factura (no puede ser nulo)
    private double total;

    
    
    
    

}
