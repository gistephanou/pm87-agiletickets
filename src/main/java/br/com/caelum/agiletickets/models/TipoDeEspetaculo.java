package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.precos.CalculoDePreco;
import br.com.caelum.agiletickets.domain.precos.CalculoDePrecoBallet;
import br.com.caelum.agiletickets.domain.precos.CalculoDePrecoCinema;
import br.com.caelum.agiletickets.domain.precos.CalculoDePrecoOrquestra;
import br.com.caelum.agiletickets.domain.precos.CalculoDePrecoShow;
import br.com.caelum.agiletickets.domain.precos.CalculoDePrecoTeatro;

public enum TipoDeEspetaculo {
	
	CINEMA(new CalculoDePrecoCinema()), 
	SHOW(new CalculoDePrecoShow()), 
	TEATRO(new CalculoDePrecoTeatro()),
	BALLET(new CalculoDePrecoBallet()),
	ORQUESTRA(new CalculoDePrecoOrquestra());
	
	private final CalculoDePreco calculoDePreco;
	
	private TipoDeEspetaculo(CalculoDePreco calculoDePreco) {
		this.calculoDePreco = calculoDePreco;
	}
	
	public CalculoDePreco getCalculoDePreco() {
		return this.calculoDePreco;
	}
	
}

