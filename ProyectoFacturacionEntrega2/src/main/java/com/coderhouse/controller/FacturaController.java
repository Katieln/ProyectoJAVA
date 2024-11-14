package com.coderhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Factura;
import com.coderhouse.services.FacturaService;

@RestController
@RequestMapping("/api/Factura")
	public class FacturaController {

		@Autowired
		private FacturaService FacturaService;

//**********PostNewFactura**********//
@PostMapping
public ResponseEntity<Factura> crearFactura(@RequestBody Factura Factura) {
	try {
		Factura newFactura = FacturaService.crearFactura(Factura);
		return ResponseEntity.status(HttpStatus.CREATED).body(newFactura);

	} catch (Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
}