package com.coderhouse.controller;



/*import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*import com.coderhouse.models.Detalle;
import com.coderhouse.services.DetalleService;*/

@RestController
@RequestMapping("/api/detalle")
public class DetalleController {

/*	@Autowired
	private DetalleService PedidoService;

	//*********GetAllPedidos***********/

	/*@GetMapping
	public ResponseEntity <List<Detalle>> getAllPedidos(){
		try {
			List<Detalle> Pedidos = PedidoService.getAllPedidos();
			return ResponseEntity.ok(Pedidos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}*/


	//*********GetPedidoByID***********//
	/*
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> getAlumnoById(@PathVariable long id) {
		try {
			Pedido Pedido = PedidoService.findById(id);
			return ResponseEntity.ok(Pedido);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	*/

	//**********PostNewPedido**********//
	/*
	 * @PostMapping public ResponseEntity<Detalle> crearPedido(@RequestBody Detalle
	 * Pedido) { try { Detalle newPedido = PedidoService.crearPedido(Pedido); return
	 * ResponseEntity.status(HttpStatus.CREATED).body(newPedido);
	 * 
	 * } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
	 */



	//*********DeletePedidoByID**********//
	/*
	 * @DeleteMapping("/{id}") public ResponseEntity<Void>
	 * deletePedido(@PathVariable Long id) { try { PedidoService.deletePedido(id);
	 * return ResponseEntity.noContent().build(); } catch (IllegalArgumentException
	 * e) { return ResponseEntity.notFound().build(); } catch (Exception e) { return
	 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); } }
	 */


	//*********UpdatePedidoByID**********//
	/*
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> updatePedidoById(@PathVariable Long id, @RequestBody Pedido PedidoDetails) {
		try {
			Pedido updatedPedido = PedidoService.updatePedido(id, PedidoDetails);
			return ResponseEntity.ok(updatedPedido);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

*/



}