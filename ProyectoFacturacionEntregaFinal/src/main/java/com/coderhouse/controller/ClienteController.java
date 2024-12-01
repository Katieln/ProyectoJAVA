package com.coderhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.models.Cliente;
import com.coderhouse.services.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private ClienteService ClienteService;

	//*********GetAllClientes***********//
	@GetMapping
	public ResponseEntity <List<Cliente>> getAllClientes(){
		try {
			List<Cliente> Clientes = ClienteService.getAllClients();
			return ResponseEntity.ok(Clientes);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	//*********GetClienteByID***********//
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getAlumnoById(@PathVariable long id) {
		try {
			Cliente Cliente = ClienteService.findById(id);
			return ResponseEntity.ok(Cliente);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	//**********PostNewCliente**********//
	@PostMapping
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente Cliente) {
		try {
			Cliente newCliente = ClienteService.saveCliente(Cliente);
			return ResponseEntity.ok(newCliente);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	//**********AddMultipleClientes**********//
	@PostMapping("/list")
	public ResponseEntity<List<Cliente>> saveClientes(@RequestBody List<Cliente> Clientes) {
	    List<Cliente> savedClientes = ClienteService.saveCliente(Clientes);
	    return new ResponseEntity<>(savedClientes, HttpStatus.CREATED);
	}


	//*********DeleteClienteByID**********//
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
		try {
			ClienteService.deleteCliente(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	//*********UpdateClienteByID**********//
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> updateClienteById(@PathVariable Long id, @RequestBody Cliente ClienteDetails) {
		try {
			Cliente updatedCliente = ClienteService.updateCliente(id, ClienteDetails);
			return ResponseEntity.ok(updatedCliente);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}





}
