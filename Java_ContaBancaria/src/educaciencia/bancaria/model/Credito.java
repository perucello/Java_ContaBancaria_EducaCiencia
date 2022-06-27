package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import educaciencia.bancaria.constantes.NomeContas;

public class Credito extends Conta {

	/** atributo float limite redefinição do método sacar, permitindo saldo negativo até o valor do limite. */
	
	public Credito() {

		this.Tipo = NomeContas.CREDITO;

	}

}

