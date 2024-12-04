package com.coderhouse.models;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Detalle {

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

    @JsonProperty("productoId")
    public Long getProductoId() {
        return producto != null ? producto.getId() : null;
    }


}