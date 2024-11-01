package com.coderhouse.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DetalleFactura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @Column(name = "factura_id", nullable = false) // Relación con la factura (no puede ser nulo)
    private Long facturaId;

    @Column(name = "producto_id", nullable = false) // Relación con el producto (no puede ser nulo)
    private Long productoId;

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

	public Long getFacturaId() {
		return facturaId;
	}

	public void setFacturaId(Long facturaId) {
		this.facturaId = facturaId;
	}

	public Long getProductoId() {
		return productoId;
	}

	public void setProductoId(Long productoId) {
		this.productoId = productoId;
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
		return "DetalleFactura [id=" + id + ", facturaId=" + facturaId + ", productoId=" + productoId + ", cantidad="
				+ cantidad + ", subtotal=" + subtotal + "]";
	}
    
    
    
    
    
    
}
