package com.coderhouse.dao;

import org.springframework.stereotype.Service;

import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class DaoFactory {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void createCliente (Cliente cliente) {
		em.persist(cliente);
	}

	@Transactional
	public void createProduct (Producto producto) {
		em.persist(producto);

	}
//*****///



}
