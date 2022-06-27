package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import educaciencia.bancaria.constantes.NomeContas;

public class Credito extends Conta {

	/** atributo float limite redefini��o do m�todo sacar, permitindo saldo negativo at� o valor do limite. */
	
	public Credito() {

		this.Tipo = NomeContas.CREDITO;

	}

}

