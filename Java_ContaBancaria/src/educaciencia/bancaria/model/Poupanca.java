package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import educaciencia.bancaria.constantes.NomeContas;

public class Poupanca extends Conta {

	private int dia_de_rendimento;
	private float taxa = (float) 0.003;

	public Poupanca() {

		this.Tipo = NomeContas.POUPANCA;

	}

	public int getDia_de_rendimento() {
		return dia_de_rendimento;
	}

	public void setDia_de_rendimento(int dia_de_rendimento) {
		this.dia_de_rendimento = dia_de_rendimento;
	}

	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

	public void calcularNovoSaldo(float dinheiro) { // rendimento da poupaça

		float valor;

		valor = dinheiro * taxa;

		this.saldo = this.saldo + valor;

	}

}

/*
 * atributo int dia de rendimento método calcularNovoSaldo, recebe a taxa de
 * rendimento da poupança e atualiza o saldo.
 */