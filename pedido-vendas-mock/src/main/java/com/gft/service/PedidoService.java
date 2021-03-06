package com.gft.service;

import java.util.List;

import com.gft.tdd.email.NotificadorEmail;
import com.gft.tdd.model.Pedido;
import com.gft.tdd.model.StatusPedido;
import com.gft.tdd.repository.Pedidos;
import com.gft.tdd.sms.NotificadorSms;

public class PedidoService {
	
	
	private List<AcaoLancamentoPedido> acoes;
	private Pedidos pedidos;
	
	
	public PedidoService(Pedidos pedidos, List<AcaoLancamentoPedido> acoes) {

		this.acoes = acoes;
		this.pedidos = pedidos;
	}

	public double lancar(Pedido pedido) {
		
		double imposto = pedido.getValor() * 0.1;
		

		acoes.forEach(a -> a.executar(pedido));
		
		return imposto;
	}

	public Pedido pagar(Long codigo) {
		Pedido pedido = pedidos.buscarPeloCodigo(codigo);
		if (!pedido.getStatus().equals(StatusPedido.PENDENTE))
			throw new StatusPedidoInvalidoException();
		pedido.setStatus(StatusPedido.PAGO);
		return pedido;
	}

}
