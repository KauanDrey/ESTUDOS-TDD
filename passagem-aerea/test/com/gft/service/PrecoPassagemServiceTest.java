package com.gft.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.gft.model.Passageiro;
import com.gft.model.TipoPassageiro;
import com.gft.model.Voo;

public class PrecoPassagemServiceTest {

	private PrecoPassagemService precoPassagemService;

	@Before
	public void inicializacao() {
		precoPassagemService = new PrecoPassagemService();

	}

	private void assertValorPassagem(Passageiro passageiro, Voo voo, double esperado) {
		double valor = precoPassagemService.calcular(passageiro, voo);
		assertEquals(esperado, valor, 0.0001);
	}

	@Test
	public void deveCalcularValorPassagemParaPassageiroGold_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Kauan", TipoPassageiro.GOLD);
		Voo voo = new Voo("Nova York", "São Paulo", 100.0);
		assertValorPassagem(passageiro, voo, 90.0);
	}

	@Test
	public void deveCalcularPassagemParaPassageiroGold_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Kauan", TipoPassageiro.GOLD);
		Voo voo = new Voo("Nova York", "São Paulo", 600.0);
		assertValorPassagem(passageiro, voo, 510.0);
	}

	@Test
	public void deveCalcularPassagemParaPassageiroSilver_ComValorAbaixoDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Kauan", TipoPassageiro.SILVER);
		Voo voo = new Voo("Nova York", "São Paulo", 100.0);
		assertValorPassagem(passageiro, voo, 94.0);

	}

	@Test
	public void deveCalcularPassagemParaPassageiroSilver_ComValorAcimaDoLimite() throws Exception {
		Passageiro passageiro = new Passageiro("Kauan", TipoPassageiro.SILVER);
		Voo voo = new Voo("Nova York", "São Paulo", 800.0);
		assertValorPassagem(passageiro, voo, 720.0);
	}

}
