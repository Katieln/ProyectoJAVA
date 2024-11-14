package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Cliente;
import com.coderhouse.repositories.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;

//*********GetAllClientes***********//
	public List<Cliente> getAllClients() {
		return ClienteRepository.findAll();
	}


//*********GetClienteByID************//
	public Cliente findById(Long id) {
		return ClienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));
	}

//**********AddNewCliente**********//
	@Transactional
	public Cliente saveCliente(Cliente Cliente) {
		return ClienteRepository.save(Cliente);
	}


//**********AddMultipleClientes**********//
	@Transactional
	public List<Cliente> saveCliente(List<Cliente> Clientes) {
	    return ClienteRepository.saveAll(Clientes);
	}


//*********DeleteClienteByID**********//
	public void deleteCliente(Long id) {
		if (!ClienteRepository.existsById(id)) {
			throw new IllegalArgumentException("Cliente no encontrado");
		}
		ClienteRepository.deleteById(id);
	}

//*********UpdateClienteByID**********//
	@Transactional
	public Cliente updateCliente(Long id, Cliente ClienteDetails) {
		Cliente Cliente = ClienteRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

		Cliente.setNombreCliente(ClienteDetails.getNombreCliente());



		return ClienteRepository.save(Cliente);
	}

}
