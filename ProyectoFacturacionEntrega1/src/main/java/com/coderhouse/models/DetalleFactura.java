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

	//******************ColumnsTable*******************//

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @ManyToOne
    @JoinColumn(name = "factura_id", nullable = false)
    private Factura factura;


    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;

    @Column(nullable = false) // Cantidad de productos en la factura (no puede ser nulo)
    private int cantidad;

    @Column(nullable = false) // Subtotal de la línea (no puede ser nulo)
    private double subtotal;

  //********************Constructor*******************//

	public DetalleFactura() {
		super();
		// TODO Auto-generated constructor stub
	}


	public DetalleFactura(Factura factura, Producto producto, int cantidad, double subtotal) {
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
