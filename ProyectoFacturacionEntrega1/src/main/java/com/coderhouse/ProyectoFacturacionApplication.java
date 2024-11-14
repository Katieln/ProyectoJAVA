package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.dao.DaoFactory;
import com.coderhouse.models.Cliente;
import com.coderhouse.models.Producto;

@SpringBootApplication
public class ProyectoFacturacionApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory dao;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFacturacionApplication.class, args);
	}



	//@Override
	public void run(String... args) throws Exception {
		try {

			Producto Producto1 = new Producto("Smartphone", 300, 8);
			Producto Producto2 = new Producto("Tablet", 250, 12);
			Producto Producto3 = new Producto("Portatil", 480, 15);


			dao.createProduct(Producto1);
			dao.createProduct(Producto2);
			dao.createProduct(Producto3);


			Cliente Cliente1 = new Cliente("Daniela");
			Cliente Cliente2 = new Cliente("Laura");
			Cliente Cliente3 = new Cliente("Danna");


			dao.createCliente(Cliente1);
			dao.createCliente(Cliente2);
			dao.createCliente(Cliente3);




		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}





}
