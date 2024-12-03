package com.coderhouse.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.dtos.FacturaDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Factura;
import com.coderhouse.models.Pedido;
import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ClienteRepository;
import com.coderhouse.repositories.FacturaRepository;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

	@Autowired
	private FacturaRepository facturaRepository;

    @Autowired
    private ProductoRepository productoRepository;



    @Autowired
    private ClienteRepository clienteRepository;


	//*********GetAllFacturas***********//

	public List<Factura> getAllFacturas() {
		return facturaRepository.findAll();
	}

	//*********GetFacturaByID************//
		public Factura findById(Long id) {
			return facturaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Factura no encontrado"));
		}


	    // ********** AddNewFactura ********** //
		@Transactional
		public Factura crearFactura(FacturaDTO facturaDTO) {
		    // Verifica que el cliente exista
		    Cliente cliente = clienteRepository.findById(facturaDTO.getClienteId())
		            .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

		    Factura factura = new Factura();
		    factura.setCliente(cliente);

		    List<Pedido> pedidos = new ArrayList<>();
		    double total = 0;

		    for (FacturaDTO.ProductoCantidad pc : facturaDTO.getProductos()) {
		        Producto producto = productoRepository.findById(pc.getProductoId())
		                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

		        // Verifica que el stock sea suficiente
		        if (producto.getStock() < pc.getCantidad()) {
		            throw new RuntimeException("Stock insuficiente para el producto: " + producto.getNombreProducto());
		        }

		        // Reduce el stock del producto
		        producto.setStock(producto.getStock() - pc.getCantidad());
		        productoRepository.save(producto);

		        Pedido pedido = new Pedido();
		        pedido.setFactura(factura);
		        pedido.setProducto(producto);
		        pedido.setCantidad(pc.getCantidad());

		        pedido.calcularSubtotal();  // Asegura que el subtotal se calcule antes de añadir a la lista
		        pedidos.add(pedido);
		        total += pedido.getSubtotal();
		    }

		    factura.setPedidos(pedidos);
		    factura.setTotal(total);

		    return facturaRepository.save(factura);
		}





	//*********DeleteFacturaByID**********//
		public void deleteFactura(Long id) {
			if (!facturaRepository.existsById(id)) {
				throw new IllegalArgumentException("Factura no encontrado");
			}
			facturaRepository.deleteById(id);
		}




}
