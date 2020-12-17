package com.gft.tdd.repository;

import com.gft.service.AcaoLancamentoPedido;
import com.gft.tdd.model.Pedido;

public class Pedidos implements AcaoLancamentoPedido {

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Salvando no banco de dados...");

	}
	
	public Pedido buscarPeloCodigo(Long codigo) {
		return new Pedido();
		
	}

}
