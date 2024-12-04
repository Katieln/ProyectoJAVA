package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.dtos.FacturaDTO;
import com.coderhouse.models.Factura;
import com.coderhouse.services.FacturaService;

@RestController
@RequestMapping("/api/Factura")
	public class FacturaController {

		@Autowired
		private FacturaService facturaService;


//*********GetAllFacturas***********//
	@GetMapping
	public ResponseEntity <List<Factura>> getAllFacturas(){
			try {
				List<Factura> Facturas = facturaService.getAllFacturas();
				return ResponseEntity.ok(Facturas);
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}

	//********GetFacturaById********//
    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) {
        try {
            Factura factura = facturaService.findById(id);
            return ResponseEntity.ok(factura);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//*******CrearFActraConProductos*******//
    
@PostMapping("/crear")
public ResponseEntity<Factura> crearFactura(@RequestBody FacturaDTO facturaDTO) {
    try {
        Factura factura = facturaService.crearFactura(facturaDTO);  // Se pasa el DTO directamente
        return ResponseEntity.status(HttpStatus.CREATED).body(factura);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

// Eliminar una factura por ID
@DeleteMapping("/{id}")
public ResponseEntity<Void> deleteFactura(@PathVariable Long id) {
    try {
        facturaService.deleteFactura(id);
        return ResponseEntity.noContent().build();
    } catch (IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}




}