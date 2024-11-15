package com.coderhouse.dtos;

import java.util.List;

public class FacturaDTO {
	    private Long clienteId;
	    private List<ProductoCantidad> productos;

	    // Getters y setters para FacturaRequest
	    public Long getClienteId() {
	        return clienteId;
	    }

	    public void setClienteId(Long clienteId) {
	        this.clienteId = clienteId;
	    }

	    public List<ProductoCantidad> getProductos() {
	        return productos;
	    }

	    public void setProductos(List<ProductoCantidad> productos) {
	        this.productos = productos;
	    }



	    public static class ProductoCantidad {
	        private Long productoId;
	        private Integer cantidad;

	     // Getters y setters para ProductoCantidad
	        public Long getProductoId() {
	            return productoId;
	        }

	        public void setProductoId(Long productoId) {
	            this.productoId = productoId;
	        }

	        public Integer getCantidad() {
	            return cantidad;
	        }

	        public void setCantidad(Integer cantidad) {
	            this.cantidad = cantidad;
	        }
	    }
	}




