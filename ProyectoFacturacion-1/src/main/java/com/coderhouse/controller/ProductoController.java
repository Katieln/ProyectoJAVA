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

import com.coderhouse.models.Producto;
import com.coderhouse.services.ProductoService;

@RestController
@RequestMapping("/api/product")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	//*********GetAllProducts***********//
	@GetMapping
	public ResponseEntity <List<Producto>> getAllProducts(){
		try {
			List<Producto> productos = productoService.getAllProducts();
			return ResponseEntity.ok(productos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	//*********GetProductByID***********//
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getAlumnoById(@PathVariable long id) {
		try {
			Producto producto = productoService.findById(id);
			return ResponseEntity.ok(producto);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	//**********PostNewProduct**********//
	@PostMapping
	public ResponseEntity<Producto> createProduct(@RequestBody Producto producto) {
		try {
			Producto newProduct = productoService.saveProduct(producto);
			return ResponseEntity.ok(newProduct);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}


	//**********AddMultipleProducts**********//
	@PostMapping("/list")
	public ResponseEntity<List<Producto>> saveProducts(@RequestBody List<Producto> productos) {
	    List<Producto> savedProducts = productoService.saveProducts(productos);
	    return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
	}


	//*********DeleteProductByID**********//
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
		try {
			productoService.deleteProduct(id);
			return ResponseEntity.noContent().build();
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}



	//*********UpdateProductByID**********//
	@PutMapping("/{id}")
	public ResponseEntity<Producto> updateProductById(@PathVariable Long id, @RequestBody Producto productDetails) {
		try {
			Producto updatedProduct = productoService.updateProduct(id, productDetails);
			return ResponseEntity.ok(updatedProduct);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}





}
