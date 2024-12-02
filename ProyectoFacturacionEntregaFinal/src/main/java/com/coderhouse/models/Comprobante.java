package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Comprobante {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "comprobanteId", nullable = false)
    private List<Pedido> pedidos = new ArrayList<>();

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private int totalProductos;

    @PrePersist
    @PreUpdate
    public void calcularTotales() {
        if (pedidos != null && !pedidos.isEmpty()) {
            this.total = pedidos.stream()
                    .mapToDouble(Pedido::getSubtotal)
                    .sum();
            this.totalProductos = pedidos.stream()
                    .mapToInt(Pedido::getCantidad)
                    .sum();
        } else {
            this.total = 0.0;
            this.totalProductos = 0;
        }
    }

}
