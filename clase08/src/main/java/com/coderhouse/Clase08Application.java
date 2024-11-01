package com.coderhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.coderhouse.models.Pasaporte;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@SpringBootApplication
public class Clase08Application {

	public static void main(String[] args) {
		SpringApplication.run(Clase08Application.class, args);
	}

	

	 
	
}
