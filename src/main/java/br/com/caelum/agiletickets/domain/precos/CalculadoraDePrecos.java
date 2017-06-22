package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public BigDecimal calcula(Sessao sessao, Integer quantidade) {
		CalculoDePreco calculador = sessao.getEspetaculo().getTipo().getCalculoDePreco();
		BigDecimal precoUnitario = calculador.calcula(sessao);
		
		return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
	}

}
