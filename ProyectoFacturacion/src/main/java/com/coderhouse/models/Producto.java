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
public class Producto {

	//******************ColumnsTable*******************//
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @Column(nullable = false) // No puede ser nulo
    private String nombreProducto;
    
    @Column(nullable = false) // No puede ser nulo
    private double precio;
    
    @Column(nullable = false) // No puede ser nulo
    private int stock;
   
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetalleFactura> detalles = new ArrayList<>();
    
  //********************Constructor*******************//
    
    
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
  public Producto(String nombreProducto, double precio, int stock) {
	super();
	this.nombreProducto = nombreProducto;
	this.precio = precio;
	this.stock = stock;
}



//********************getters & setters*******************//
  
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	//**********************ToString***************************//
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", precio=" + precio + ", stock=" + stock
				+ ", detalles=" + detalles + "]";
	}

    
    
    
    
    
}

