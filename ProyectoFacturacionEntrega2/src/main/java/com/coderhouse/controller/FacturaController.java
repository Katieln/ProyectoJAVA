package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.FacturaDTO;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Factura;
import com.coderhouse.services.FacturaService;

@RestController
@RequestMapping("/api/Factura")
	public class FacturaController {

		@Autowired
		private FacturaService facturaService;






//Método para crear una nueva factura con productos
@PostMapping("/crear")
public ResponseEntity<Factura> crearFactura(@RequestBody FacturaDTO facturaDTO) {
    try {
        Factura factura = facturaService.crearFactura(facturaDTO);  // Se pasa el DTO directamente
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}





}