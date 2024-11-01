package com.coderhouse.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Factura {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único del cliente

    @ManyToOne // Una factura pertenece a un solo cliente
    @JoinColumn(name = "cliente_id", nullable = false) // Relación con el cliente (no puede ser nulo)
    private Cliente cliente;

    @Temporal(TemporalType.DATE) // Tipo de dato para la fecha
    @Column(nullable = false) // No puede ser nulo
    private Date fecha;

    @Column(nullable = false) // Total de la factura (no puede ser nulo)
    private double total;

    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)
    private List<DetalleFactura> detalles; // Relación con los detalles de la factura

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", cliente=" + cliente + ", fecha=" + fecha + ", total=" + total + ", detalles="
				+ detalles + "]";
	}

    
    
    
    

}
