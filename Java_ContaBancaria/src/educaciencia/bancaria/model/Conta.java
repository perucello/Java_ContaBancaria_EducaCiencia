package educaciencia.bancaria.model;

/** ************************************** 
 *  ******** EDUCACIENCIA FASTCODE *******
 *  **************************************/

import educaciencia.bancaria.controller.ControllerContaBancariaCliente;

public abstract class Conta {

	protected String Tipo;
	protected float saldo = 0;

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void sacar_dinheiro(float valor) {

		if (valor <= this.saldo && valor > 0) {

			this.saldo -= valor;

		}

	}

	public void depositar_dinheiro(float valor) {

		if (valor != 0 && valor > 0) {

			this.saldo += valor;

		}

	}

	public void transferir_dinheiro(float valor, int chave_pix) {

		if (valor <= this.saldo && valor > 0) {

			if (enviar_saldo(chave_pix, valor)) {

				this.saldo -= valor;

			}
		}
	}

	private boolean enviar_saldo(int pix, float valor) {

		boolean resposta = false;

		if (ControllerContaBancariaCliente.getClientes().get(pix) != null) {

			ControllerContaBancariaCliente.getClientes().get(pix).getContaBancaria().getContascliente().get(1)
					.depositar_dinheiro(valor);

			resposta = true;

		}

		return resposta;
	}

}
