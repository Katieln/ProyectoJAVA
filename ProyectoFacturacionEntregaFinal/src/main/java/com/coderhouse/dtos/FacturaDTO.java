package com.coderhouse.dtos;

import java.util.List;

import lombok.Data;

@Data
public class FacturaDTO {
	    private Long clienteId;
	    private List<ProductoCantidad> productos;





	    @Data
	    public static class ProductoCantidad {
	        private Long productoId;
	        private Integer cantidad;


	    }
	}




