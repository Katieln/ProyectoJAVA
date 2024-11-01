package com.coderhouse.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Producto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @Column(nullable = false) // No puede ser nulo
    private String nombreProducto;
    
    @Column(nullable = false) // No puede ser nulo
    private double precio;
    
    @Column(nullable = false) // No puede ser nulo
    private int stock;
   

    
    
}

