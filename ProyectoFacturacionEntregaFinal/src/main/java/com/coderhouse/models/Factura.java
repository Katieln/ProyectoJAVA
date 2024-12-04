package com.coderhouse.models;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

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
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false)
    private double total;


    @ManyToOne
    @JoinColumn(name = "clienteId", nullable = false)
    @JsonBackReference("cliente-reference")  // Usado aquí para evitar la serialización recursiva de la relación con 'Cliente'
    private Cliente cliente;




    @OneToMany(mappedBy = "factura", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference("factura-reference")  // Usado para serializar la lista de 'Pedido' dentro de 'Factura'
    private List<Detalle> pedidos = new ArrayList<>();


    // Método para actualizar el total de la factura
    @PostPersist
    @PostUpdate
    public void calcularTotal() {
        this.total = pedidos.stream().mapToDouble(Detalle::getSubtotal).sum();
    }

    @JsonProperty("clienteId")
    public Long getClienteId() {
        return cliente != null ? cliente.getId() : null;
    }
    }

 









