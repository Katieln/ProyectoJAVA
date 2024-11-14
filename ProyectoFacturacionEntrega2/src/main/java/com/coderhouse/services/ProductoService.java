package com.coderhouse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Producto;
import com.coderhouse.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

//*********GetAllProducts***********//
	public List<Producto> getAllProducts() {
		return productoRepository.findAll();
	}


//*********GetProductByID***********//
	public Producto findById(Long id) {
		return productoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
	}

//**********AddNewProduct**********//
	@Transactional
	public Producto saveProduct(Producto producto) {
		return productoRepository.save(producto);
	}


//**********AddMultipleProducts**********//
	@Transactional
	public List<Producto> saveProducts(List<Producto> productos) {
	    return productoRepository.saveAll(productos);
	}


//*********DeleteProductByID**********//
	public void deleteProduct(Long id) {
		if (!productoRepository.existsById(id)) {
			throw new IllegalArgumentException("Producto no encontrado");
		}
		productoRepository.deleteById(id);
	}

//*********UpdateProductByID**********//
	@Transactional
	public Producto updateProduct(Long id, Producto productDetails) {
		Producto producto = productoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

		producto.setNombreProducto(productDetails.getNombreProducto());

		producto.setStock(productDetails.getStock());

		if (productDetails.getPrecio() != 0 ) {
			producto.setPrecio(productDetails.getPrecio());
		}

		return productoRepository.save(producto);
	}

}
