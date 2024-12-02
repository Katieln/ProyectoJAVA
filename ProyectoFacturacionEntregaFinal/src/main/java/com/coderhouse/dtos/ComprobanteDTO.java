package com.coderhouse.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.coderhouse.models.Comprobante;
import com.coderhouse.models.Pedido;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ComprobanteDTO {

    private Long id;
    private LocalDateTime fecha;
    private Long clienteId;
    private List<Long> pedidosIds;
    private double total;
    private int totalProductos;

    // Constructor adicional para mapear directamente
    public ComprobanteDTO(Comprobante comprobante) {
        this.id = comprobante.getId();
        this.fecha = comprobante.getFecha();
        this.clienteId = comprobante.getCliente().getId();
        this.pedidosIds = comprobante.getPedidos().stream()
                            .map(Pedido::getId)
                            .collect(Collectors.toList());
        this.total = comprobante.getTotal();
        this.totalProductos = comprobante.getTotalProductos();
    }
}
 