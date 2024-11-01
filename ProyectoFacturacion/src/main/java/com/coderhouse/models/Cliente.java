package com.coderhouse.models;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Cliente {

	//******************ColumnsTable*******************//
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @Column (name = "nombreCliente")
    private String nombreCliente; // Nombre del cliente
    
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Factura> facturas = new ArrayList<>();
    

    //********************Constructor*******************//
    
	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(String nombreCliente) {
		super();
		this.nombreCliente = nombreCliente;
	}

	
    
  //********************getters & setters*******************//

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public List<Factura> getFacturas() {
		return facturas;
	}


	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}
	

	//**********************ToString***************************//
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombreCliente=" + nombreCliente + ", facturas=" + facturas + "]";
	}



    
    
    
    
    
}