package com.coderhouse.models;



import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private int stock;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("producto-reference")  // Usado para serializar la lista de 'Pedido' dentro de 'Producto'
    private List<Pedido> detalles = new ArrayList<>();

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

	public List<Pedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Pedido> detalles) {
		this.detalles = detalles;
	}

	//**********************ToString***************************//

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombreProducto=" + nombreProducto + ", precio=" + precio + ", stock=" + stock
				+ ", detalles=" + detalles + "]";
	}






}
