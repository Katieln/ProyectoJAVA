package com.coderhouse.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.models.Pedido;
import com.coderhouse.repositories.PedidoRepository;

import jakarta.transaction.Transactional;


@Service
public class PedidoService {

	@Autowired
	private PedidoRepository PedidoRepository;

	//*********GetAllPedidos***********//

		public List<Pedido> getAllPedidos() {
			return PedidoRepository.findAll();
		}



 //*********GetPedidoByID************
		public Pedido findById(Long id) {
			return PedidoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado"));
		}




	//**********AddNewPedido**********//
		@Transactional
		public Pedido crearPedido(Pedido Pedido) {
			return PedidoRepository.save(Pedido);
		}







	//*********DeletePedidoByID**********//
		public void deletePedido(Long id) {
			if (!PedidoRepository.existsById(id)) {
				throw new IllegalArgumentException("Pedido no encontrado");
			}
			PedidoRepository.deleteById(id);
		}

	//*********UpdatePedidoByID**********//


		/*@Transactional
		public Pedido updatePedido(Long id, Pedido PedidoDetails) {
			Pedido Pedido = PedidoRepository.findById(id)
					.orElseThrow(() -> new IllegalArgumentException("Alumno no encontrado"));

			Pedido.setNombrePedido(PedidoDetails.getNombrePedido());



			return PedidoRepository.save(Pedido);
		}*/

	}
