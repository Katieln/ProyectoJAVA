package com.coderhouse.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.coderhouse.dtos.ComprobanteDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Comprobante;
import com.coderhouse.models.Pedido;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.ComprobanteRepository;
import com.coderhouse.repositories.PedidoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComprobanteService {

    private final ComprobanteRepository comprobanteRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoRepository pedidoRepository;

    public ComprobanteDTO crearComprobante(Long clienteId, List<Long> pedidoIds) {
        // Validar existencia del cliente
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        // Validar y obtener los pedidos
        List<Pedido> pedidos = pedidoRepository.findAllById(pedidoIds);
        if (pedidos.isEmpty() || pedidos.size() != pedidoIds.size()) {
            throw new IllegalArgumentException("Algunos pedidos no existen");
        }

        // Validar stock de productos en pedidos
        for (Pedido pedido : pedidos) {
            Producto producto = pedido.getProducto();
            if (pedido.getCantidad() > producto.getStock()) {
                throw new IllegalArgumentException(
                        "Stock insuficiente para el producto " + producto.getNombreProducto());
            }
            // Reducir stock
            producto.setStock(producto.getStock() - pedido.getCantidad());
        }

        // Crear el comprobante
        Comprobante comprobante = new Comprobante();
        comprobante.setCliente(cliente);
        comprobante.setPedidos(pedidos);
        comprobante.calcularTotales();

        // Guardar comprobante
        comprobante = comprobanteRepository.save(comprobante);

        // Retornar como DTO
        return new ComprobanteDTO(comprobante);
    }

    public List<ComprobanteDTO> listarComprobantes() {
        return comprobanteRepository.findAll().stream()
                .map(ComprobanteDTO::new)
                .collect(Collectors.toList());
    }

    public ComprobanteDTO obtenerComprobantePorId(Long id) {
        Comprobante comprobante = comprobanteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Comprobante no encontrado"));
        return new ComprobanteDTO(comprobante);
    }
    
}
