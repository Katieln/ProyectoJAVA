package com.coderhouse.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
    
    @OneToMany(mappedBy = "factura") // Relación One-to-Many con DetalleFactura
    private List<DetalleFactura> detalles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
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
		return "Factura [id=" + id + ", clienteId=" + clienteId + ", fecha=" + fecha + ", total=" + total + "]";
	}

    
    
    
    

}
