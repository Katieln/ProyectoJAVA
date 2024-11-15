package com.coderhouse.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "facturaId", nullable = false)
    @JsonBackReference("factura-reference")   // Se usa para evitar serialización recursiva de la relación con 'Factura'
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "productoId", nullable = false)
    @JsonBackReference("producto-reference")   // Se usa para evitar serialización recursiva de la relación con 'Producto'
    private Producto producto;

    @Column(nullable = false)
    private int cantidad;

    @Column(nullable = false)
    private double subtotal;

    @PrePersist
    @PreUpdate
    public void calcularSubtotal() {
        if (producto != null) {
            this.subtotal = this.producto.getPrecio() * this.cantidad;
        }
    }




  //********************Constructor*******************//

	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Pedido(Factura factura, Producto producto, int cantidad, double subtotal) {
		super();
		this.factura = factura;
		this.producto = producto;
		this.cantidad = cantidad;
		this.subtotal = subtotal;
	}


  //********************getters & setters*******************//

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




	//**********************ToString***************************//

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", factura=" + factura + ", producto=" + producto + ", cantidad=" + cantidad
				+ ", subtotal=" + subtotal + "]";
	}








}