package com.gft.tdd.email;

import com.gft.service.AcaoLancamentoPedido;
import com.gft.tdd.model.Pedido;

public class NotificadorEmail implements AcaoLancamentoPedido {
	

	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando email...");		
	}

}
