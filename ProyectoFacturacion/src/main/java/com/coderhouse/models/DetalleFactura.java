package com.coderhouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class DetalleFactura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @ManyToOne // Un detalle de factura pertenece a una factura
    @JoinColumn(name = "factura_id", nullable = false) // Relación con la factura (no puede ser nulo)
    private Factura factura;


    @ManyToOne // Un detalle de factura pertenece a un producto
    @JoinColumn(name = "producto_id", nullable = false) // Relación con el producto (no puede ser nulo)
    private Producto producto;

    @Column(nullable = false) // Cantidad de productos en la factura (no puede ser nulo)
    private int cantidad;

    @Column(nullable = false) // Subtotal de la línea (no puede ser nulo)
    private double subtotal;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", factura=" + factura + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", subtotal=" + subtotal + "]";
	}

    
    
  
    
    
    
}
