package com.gft.tdd.sms;

import com.gft.service.AcaoLancamentoPedido;
import com.gft.tdd.model.Pedido;

public class NotificadorSms implements AcaoLancamentoPedido {


	@Override
	public void executar(Pedido pedido) {
		System.out.println("Enviando o sms...");
		
	}
	
}
