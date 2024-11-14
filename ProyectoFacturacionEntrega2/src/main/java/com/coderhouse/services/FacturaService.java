package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Factura;
import com.coderhouse.repositories.FacturaRepository;

import jakarta.transaction.Transactional;

@Service
public class FacturaService {

	@Autowired
	private FacturaRepository FacturaRepository;


	//*********GetAllFacturas***********//

	public List<Factura> getAllFacturas() {
		return FacturaRepository.findAll();
	}


	//**********AddNewFactura**********//
	@Transactional
	public Factura crearFactura(Factura Factura) {
		return FacturaRepository.save(Factura);
	}





}
